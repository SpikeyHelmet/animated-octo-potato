package com.tasks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.models.Models;

@WebServlet("/insert")
public class addMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addMarks() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentid = request.getParameter("studentid");
		String dept = request.getParameter("dept");
		String subjectid = request.getParameter("subjectid");
		String marks = request.getParameter("marks");
		
		PrintWriter writer = response.getWriter();
		
		
		Models model = new Models();
		int value = model.addMarksModel(studentid, subjectid, marks, dept);
		
        if (value > 0) {
            writer.println("===============");
            writer.println("Query Executed Successfully!");
            writer.println("===============");
        } else {
           writer.println("Query Failed!");
        }

		writer.close();
	}

}
