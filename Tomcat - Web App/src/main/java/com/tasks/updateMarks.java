package com.tasks;

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

@WebServlet("/updatemarks")
public class updateMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateMarks() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentid = request.getParameter("studentid");
		String dept = request.getParameter("dept");
		String subjectid = request.getParameter("subjectid");
		String marks = request.getParameter("marks");
		
		PrintWriter writer = response.getWriter();
		
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://in03.bya.ac:3306/" + dept, "u143_V8d54d6jFy", "a.X.lLMvRyNw.3o=G.WjZK47");
		
		PreparedStatement pstmt = con
                .prepareStatement("UPDATE Results SET `Mark` = ? WHERE `Student ID`= ? AND `Subject ID`= ?");
        pstmt.setString(1, marks);
        pstmt.setString(2, studentid);
        pstmt.setString(3, subjectid);
        
        int count = pstmt.executeUpdate();
        
        if (count > 0) {
            writer.println("===============");
            writer.println("Query Executed Successfully!");
            writer.println("===============");
        } else {
           writer.println("Query Failed!");
        }

        con.close();
		
		}catch (SQLException e) {
            writer.println("SQL Exception: " + e.getMessage());
            writer.println("SQL State: " + e.getSQLState());
        } catch (Exception e) {
            writer.println("Exception: " + e.getMessage());
		}
		writer.close();
	}

}
