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
      Connection con = DriverManager.getConnection("jdbc:mysql://23.88.33.117:3306/s2424_spikey", "u2424_3iEuNEPWwN", "sEzylB843jS9Epi6+bKTEN=!");
	
      PreparedStatement stmt = con.prepareStatement("SELECT * FROM Authentication WHERE Username = ? AND Password = ?");
      
      stmt.setString(1, name);
      stmt.setString(2, password);
      
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
    	   		  
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
	System.out.println("Getting Called!");
    subject.getPrincipals().remove(userPrincipal);
    subject.getPrincipals().remove(rolePrincipal);
    return true;
    
  }

}