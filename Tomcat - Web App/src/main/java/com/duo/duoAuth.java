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
		String opt1 = request.getParameter("sms");
		String opt2 = request.getParameter("phone");
		String opt3 = request.getParameter("push");
		String opt4 = request.getParameter("passcode");
		
		String option=null;
		if(opt1!=null)
		{
			option=opt1;
		}
		else if(opt2!=null) {
			option=opt2;
		}
		else if(opt3!=null) {
			option=opt3;
		}
		else if(opt4!=null) {
			option=opt4;
		}
		
		System.out.println("User ID: " + uid);
		System.out.println(opt1);
		System.out.println(opt2);
		System.out.println(opt3);
		System.out.println(option);
		
		   Http req = new Http("POST", System.getenv("host"), "/auth/v2/auth");
		      
		      try {
				req.addParam("user_id", uid);
				
				if(option == opt4)
				{
				System.out.println("Yes");
			    req.addParam("factor", "passcode");
			    req.addParam("passcode", option);
				}
				else if(option.equalsIgnoreCase("push"))
				{
					System.out.println("Yes2");
				req.addParam("factor", "push");
				req.addParam("device", "auto");
				}
				else if(option.equalsIgnoreCase("phone"))
				{
					System.out.println("Yes3");
				req.addParam("factor", "phone");
				req.addParam("device", "auto");	
				}
				else if(option.equalsIgnoreCase("sms"))
				{
					System.out.println("Yes4");
				req.addParam("factor", "sms");
				req.addParam("device", "auto");
				}
				
				System.out.println(req.toString());
				
				 req.signRequest(System.getenv("ikey"),
						  System.getenv("skey"));

		      
				
			    JSONObject res = (JSONObject) req.executeRequest();
			    System.out.println(res);
			     
			    String status = res.getString("result");
			     
			     if(status.equalsIgnoreCase("allow")) {
			    	 Cookie ck = new Cookie("duo","Authenticated");
			    	 ck.setMaxAge(1200);
			    	 response.addCookie(ck);
			    	 response.sendRedirect("views/index.jsp");
			     }
			     else if (status.equalsIgnoreCase("deny") && option.equalsIgnoreCase("sms"))
			     {
			    	 response.sendRedirect("views/passcode.jsp?userid="+uid);
			     }
			     else if (status.equalsIgnoreCase("deny")){
			    	 request.setAttribute("userid", uid);
			    	 response.sendRedirect("views/AuthM.jsp");
			     }
			     
		    } catch (Exception e) {
		        writer.println("<h3>Exception: " + e.getMessage()+ "</h3>");
			}
		   
	writer.close();
		
	}

}
