package com.tasks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.*;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.directory.api.util.GeneralizedTime;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.Filter;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;
import com.unboundid.ldap.sdk.experimental.ActiveDirectoryDirSyncControl;


@WebServlet("/ADSync")
public class ADSync extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ADSync() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr = request.getParameter("username");
		String password = request.getParameter("password");
		String domain = request.getParameter("domain");
		String base = request.getParameter("base");
		
		System.setProperty("userHost", domain);
		String filter;

		filter = "(&(objectClass=user)(!(objectCategory=computer)))";
		
    	try {
		LDAPConnection c = new LDAPConnection(domain, 389, usr, password);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection( System.getenv("mysqlhost")+ "/CSE", System.getenv("mysqlusr"), System.getenv("mysqlpw") );
		
		 final SearchRequest searchRequest = new SearchRequest(base,
			      SearchScope.SUB, filter);

		 ASN1OctetString cookie = null;
		 final int flags = ActiveDirectoryDirSyncControl.FLAG_INCREMENTAL_VALUES |
		      ActiveDirectoryDirSyncControl.FLAG_OBJECT_SECURITY;


		 while (true)
		 {

		   searchRequest.setControls(new ActiveDirectoryDirSyncControl(true, flags,
		        50, cookie));

		   final SearchResult searchResult = c.search(searchRequest);
		   
		   ActiveDirectoryDirSyncControl dirSyncResponse =
		        ActiveDirectoryDirSyncControl.get(searchResult);
		   cookie = dirSyncResponse.getCookie();

		   for (final SearchResultEntry e :
		        searchResult.getSearchEntries())
		   {
			   	System.out.println(e);
			   	String accPath = e.getDN();
		    	String accName = e.getAttributeValue("sAMAccountName");
		    	String accRole = e.getAttributeValue("title");
		    	String isDeleted = e.getAttributeValue("isDeleted");
			    System.out.println("name: " + accName);
			    System.out.println("Role: " + accRole);
			    System.out.println("Path: " + accPath);
			    
			      PreparedStatement stmt = con.prepareStatement("SELECT * FROM Authentication WHERE `Username` = ? OR `Path` = ?");
			      stmt.setString(1, accName);
			      stmt.setString(2, accPath);
			      ResultSet rs = stmt.executeQuery();
			      

			      if (rs.next()) {
			    	  if(rs.getString("Role") != accRole && isDeleted == null) {
			    		  PreparedStatement pinsstmt = con.prepareStatement("UPDATE Authentication SET `Role`= ? WHERE `Username`= ? OR `Path` = ?");
				    	     pinsstmt.setString(1, accRole);
				    	     pinsstmt.setString(2, accName);
				    	     pinsstmt.setString(3, accPath);
				    	     int count = pinsstmt.executeUpdate();
			    	  }else if(isDeleted!= null && isDeleted.equalsIgnoreCase("TRUE")) {
			    		  PreparedStatement pinsstmt = con.prepareStatement("DELETE FROM Authentication WHERE `Path` = ? OR `Username` = ?");
				    	     pinsstmt.setString(1, accPath);
				    	     pinsstmt.setString(2, accName);
				    	     int count = pinsstmt.executeUpdate();
						     System.out.println("DELTED: " + e.getAttributeValue("isDeleted") + " " + count);
						     
			    	  }
			      }
			      else if(isDeleted == null)
			      {
			  		     PreparedStatement pinsstmt = con.prepareStatement("INSERT INTO Authentication (`Username`,`Password`,`Role`,`userid`, `Path`) VALUES (?,NULL,?,NULL,?)");
			    	     pinsstmt.setString(1, accName);
			    	     pinsstmt.setString(2, accRole);
			    	     pinsstmt.setString(3, accPath);
			    	     int count = pinsstmt.executeUpdate();
			      }
		   }
		   
		   //Persist entry if needed
		 }
		

		
		}catch(Exception exc)
		{
			System.out.println(exc);
		}
		
	}

}
