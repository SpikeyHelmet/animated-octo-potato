package com.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "logoutServlet", urlPatterns = {"/logout"})
public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
  
    protected void doGet(HttpServletRequest request,
      HttpServletResponse response) 
        throws ServletException, IOException {
    	
      request.logout();
      response.sendRedirect(request.getContextPath() 
        + "/Check.jsp");
      
    }

}
