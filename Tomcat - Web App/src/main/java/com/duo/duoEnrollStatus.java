package com.duo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.duosecurity.client.Http;

@WebServlet("/duoEnrollStatus")
public class duoEnrollStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public duoEnrollStatus() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter writer = response.getWriter();
		
		String uid = request.getParameter("userid");
		String code = request.getParameter("activation_code");
		String user = request.getRemoteUser();
		
		   Http req = new Http("POST", System.getenv("host"), "/auth/v2/enroll_status");
		      
		      try {
			     Class.forName("com.mysql.cj.jdbc.Driver");
			     req.addParam("user_id", uid);
			     req.addParam("activation_code", code);
				 req.signRequest(System.getenv("ikey"),
						  System.getenv("skey"));
				 
			     String abc = req.executeRequest().toString();

			     if(abc.equalsIgnoreCase("success")){
			    	 
			      Connection con = DriverManager.getConnection("jdbc:mysql://23.88.33.117:3306/s2424_spikey", "u2424_3iEuNEPWwN", "sEzylB843jS9Epi6+bKTEN=!");
				
					PreparedStatement pstmt = con
			                .prepareStatement("UPDATE Authentication SET `userid`= ? WHERE `Username`= ?");
			        
				  
			      if(user !=null) {
			      pstmt.setString(1, uid);
			      pstmt.setString(2, user);
			      }
			      else
			      {
			    	  throw new Exception("Invalid");
			      }
			      
			      int count = pstmt.executeUpdate();
			      
			      if (count>0) {
	    	   			response.sendRedirect(request.getContextPath() + "/duoPreauth");
			      }
    	   		  else
    	   		  {
    	   			throw new Exception("Error Something failed! Try Again");
    	   		  }
			      
		      }
			     
		      }catch (SQLException e) {
		        writer.println("<h3>SQL Exception: " + e.getMessage() + "</h3>");
		        writer.println("<h3>SQL State: " + e.getSQLState()+ "</h3>");
		    } catch (Exception e) {
		        writer.println("<h3>Exception: " + e.getMessage()+ "</h3>");
			}
		      writer.close();
	}

}
