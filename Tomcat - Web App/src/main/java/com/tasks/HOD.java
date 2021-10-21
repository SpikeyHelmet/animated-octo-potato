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


@WebServlet("/hod")
public class HOD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HOD() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dept = request.getParameter("dept");
		String sem = request.getParameter("semester");
		
		PrintWriter writer = response.getWriter();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://23.88.33.117:3306/" + dept, "u2424_3iEuNEPWwN", "sEzylB843jS9Epi6+bKTEN=!");
		
		 Statement stmt = con.createStatement();

         String query = "SELECT r.`Student ID` ,r.`Subject ID`, s.`Subject Code`, r.Mark , st.`Student Name` FROM Results r LEFT JOIN Subjects s ON r.`Subject ID` = s.`Subject ID` LEFT JOIN Students st ON st.`Student ID` = r.`Student ID` WHERE s.Semester = " + sem; 

         ResultSet rs = stmt.executeQuery(query);
         
         writer.println("Department: "+ dept);
         writer.println("Semester: "+ sem);
         writer.println("===========================================================================");
         writer.println("Student ID    Subject ID     Subject Code        Mark        Student Name");
         writer.println("===========================================================================");
         while (rs.next()) {
             writer.println("      " + rs.getString(1) + "            " + rs.getString(2) + "            " + rs.getString(3)  + "            " + rs.getString(4)  + "            " + rs.getString(5));
         }
         writer.println("===========================================================================");
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
