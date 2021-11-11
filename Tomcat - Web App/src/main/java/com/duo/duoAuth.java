package com.duo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.duosecurity.client.Http;

@WebServlet("/duoAuth")
public class duoAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public duoAuth() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		
		String uid = request.getParameter("userid");
		String passcode = request.getParameter("passcode");
		
		System.out.println(uid);
		System.out.println(passcode);
		
		   Http req = new Http("POST", System.getenv("host"), "/auth/v2/auth");
		      
		      try {
				req.addParam("user_id", uid);
			    req.addParam("factor", "passcode");
			    req.addParam("passcode", passcode);
				 req.signRequest(System.getenv("ikey"),
						  System.getenv("skey"));

		      
				
			    JSONObject res = (JSONObject) req.executeRequest();
			    System.out.println(res);
			     
			    String status = res.getString("result");
			     
			     if(status.equalsIgnoreCase("allow")) {
			    	 Cookie ck = new Cookie("duo","Authenticated");
			    	 ck.setMaxAge(6400);
			    	 response.addCookie(ck);
			    	 response.sendRedirect("views/index.jsp");
			     }
			     else if (status.equalsIgnoreCase("deny"))
			     {
			    	 response.sendRedirect("views/passcode.jsp");
			     }
			     
		    } catch (Exception e) {
		        writer.println("<h3>Exception: " + e.getMessage()+ "</h3>");
			}
		   
	writer.close();
		
	}

}
