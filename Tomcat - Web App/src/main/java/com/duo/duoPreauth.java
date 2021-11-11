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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		      Connection con = DriverManager.getConnection("jdbc:mysql://23.88.33.117:3306/s2424_spikey", "u2424_3iEuNEPWwN", "sEzylB843jS9Epi6+bKTEN=!");
			
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
    	   		  if(uid == null)
    	   		  {
    	   			response.sendRedirect(request.getContextPath() + "/duoEnroll");
    	   		  }
    	   		  else
    	   		  {
    	   			request.setAttribute("userid", uid);
    	   			request.getRequestDispatcher("views/passcode.jsp").forward(request, response);
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
