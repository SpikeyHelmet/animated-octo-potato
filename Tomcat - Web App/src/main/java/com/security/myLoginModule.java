package com.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.unboundid.ldap.sdk.LDAPConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class myLoginModule implements LoginModule {

  private CallbackHandler handler;
  private Subject subject;
  private UserPrincipal userPrincipal;
  private RolePrincipal rolePrincipal;
  private String login;
  private List<String> userGroups;

  @Override
  public void initialize(Subject subject,
      CallbackHandler callbackHandler,
      Map<String, ?> sharedState,
      Map<String, ?> options) {

    handler = callbackHandler;
    this.subject = subject;
  }

  @Override
  public boolean login() throws LoginException {

    Callback[] callbacks = new Callback[2];
    callbacks[0] = new NameCallback("login");
    callbacks[1] = new PasswordCallback("password", true);

    try {
    	
      handler.handle(callbacks);
      String name = ((NameCallback) callbacks[0]).getName();
      String password = String.valueOf(((PasswordCallback) callbacks[1])
          .getPassword());

      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection( System.getenv("mysqlhost")+ "/CSE", System.getenv("mysqlusr"), System.getenv("mysqlpw") );
	
      PreparedStatement stmt = con.prepareStatement("SELECT * FROM Authentication WHERE Username = ?");
      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();
      String usrHost = System.getProperty("userHost");
      LDAPConnection c = new LDAPConnection( usrHost, 389, name+"@"+usrHost , password);
      
      if (rs.next() & c.isConnected()) {
          login = name;
          userGroups = new ArrayList<String>();
          userGroups.add(rs.getString("Role"));
      }
      else
    	  {
              // If credentials are INVALID we throw a LoginException
        	  con.close();
              throw new LoginException("Authentication failed");
    	  }
      
          c.close();
          con.close();
          return true;

    } catch (SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
    } catch (Exception e) {
    	throw new LoginException(e.getMessage());
    }
    
    return false;
  }

  @Override
  public boolean commit() throws LoginException {

    userPrincipal = new UserPrincipal(login);
    subject.getPrincipals().add(userPrincipal);

    if (userGroups != null && userGroups.size() > 0) {
      for (String groupName : userGroups) {
        rolePrincipal = new RolePrincipal(groupName);
        subject.getPrincipals().add(rolePrincipal);
      }
    }

    return true;
  }

  @Override
  public boolean abort() throws LoginException {
    return false;
  }

  @Override
  public boolean logout() throws LoginException {
    subject.getPrincipals().remove(userPrincipal);
    subject.getPrincipals().remove(rolePrincipal);
    return true;
  }

}