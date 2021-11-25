package com.duo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.duosecurity.client.Http;

@WebServlet("/duoPreauth")
public class duoPreauth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public duoPreauth() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      Connection con = DriverManager.getConnection( System.getenv("mysqlhost") + "/CSE", System.getenv("mysqlusr"), System.getenv("mysqlpw") );
			
		      PreparedStatement stmt = con.prepareStatement("SELECT * FROM Authentication WHERE Username = ?");
		      
		      if(request.getRemoteUser() !=null) {
		      stmt.setString(1, request.getRemoteUser());
		      }
		      else
		      {
		    	  response.sendRedirect("Auth.jsp");
		      }
		      
		      ResultSet rs = stmt.executeQuery();
		      
		      if (rs.next()) {
			      String uid = rs.getString("userid");
    	   		  if(uid != null)
    	   		  {
    	   		   Http req = new Http("POST", System.getenv("host"), "/auth/v2/preauth");
    	 	      
	    	 	      try {
	    	 	    	 req.addParam("user_id", uid);
	    	 			 req.signRequest(System.getenv("ikey"),
	    	 					  System.getenv("skey"));
	    	 	      
	    	 			 JSONObject result = null;
	    	 		     result = (JSONObject)req.executeRequest();
	    	 		     String status = result.getString("result");
	    	 		     if(status.equalsIgnoreCase("auth"))
	    	 		     {
	    	    	   			request.setAttribute("userid", uid);
	    	    	   			request.getRequestDispatcher("views/AuthM.jsp").forward(request, response);
	    	 		     }else if(status.equalsIgnoreCase("allow"))
	    	 		     {
	    			    	 Cookie ck = new Cookie("duo","Authenticated");
	    			    	 ck.setMaxAge(1200);
	    			    	 response.addCookie(ck);
	    			    	 response.sendRedirect("views/index.jsp");
	    	 		     }else if(status.equalsIgnoreCase("deny"))
	    	 		     {
	    	 		    	throw new Exception("Your access has been denied");
	    	 		     }
	    	 		     else if(status.equalsIgnoreCase("enroll")) {
	    	    	   			response.sendRedirect(request.getContextPath() + "/duoEnroll");
	    	 		     }
	    	 		     
	    	 	      }
	    	 	      catch(Exception e)
	    	 	      {
	    	 	    	 System.out.println(e);
	    	 	      }

    	   		  }
    	   		  else
    	   		  {
    	   			response.sendRedirect(request.getContextPath() + "/duoEnroll");

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
