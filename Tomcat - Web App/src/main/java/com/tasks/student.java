package com.tasks;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public student() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentid = request.getParameter("studentid");
		String dept = request.getParameter("dept");
		
		PrintWriter writer = response.getWriter();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection( System.getenv("mysqlhost") + dept, System.getenv("mysqlusr"), System.getenv("mysqlpw") );
		
		 Statement stmt = con.createStatement();

         String query = "SELECT r.`Subject ID`, s.`Subject Code`, r.Mark FROM Results r LEFT JOIN Subjects s ON r.`Subject ID` = s.`Subject ID` WHERE r.`Student ID` = " + studentid; 

         ResultSet rs = stmt.executeQuery(query);
         
         writer.println("Student ID: "+ studentid);
         writer.println("=============================================");
         writer.println("Subject ID    Subject Code     Marks Obtained");
         writer.println("=============================================");
         while (rs.next()) {
             writer.println("      " + rs.getString(1) + "            " + rs.getString(2) + "            " + rs.getString(3));
         }
         writer.println("=============================================");
         con.close();

		
		}catch (SQLException e) {
            writer.println("<h3>SQL Exception: " + e.getMessage() + "</h3>");
            writer.println("<h3>SQL State: " + e.getSQLState()+ "</h3>");
        } catch (Exception e) {
            writer.println("<h3>Exception: " + e.getMessage()+ "</h3>");
		}
		writer.close();
	}

}
