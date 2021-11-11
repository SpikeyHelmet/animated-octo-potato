package com.duo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.duosecurity.client.Http;



@WebServlet("/duoEnroll")
public class duoEnroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public duoEnroll() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   response.setContentType("text/html");
	   PrintWriter writer = response.getWriter();
		
	   Http req = new Http("POST", System.getenv("host"), "/auth/v2/enroll");
	      
	      try {
	    	  
			 req.signRequest(System.getenv("ikey"),
					  System.getenv("skey"));
	      
			 JSONObject result = null;
		     result = (JSONObject)req.executeRequest();
		     
		     String barcode= (String) result.get("activation_barcode");
		     String actcode= (String) result.get("activation_code");
		     String userid = (String) result.get("user_id");
		     writer.print("<!DOCTYPE html>\n"
		     		+ "<html>\n"
		     		+ "<head>\n"
		     		+ "<meta charset=\"UTF-8\">\n"
		     		+ "<title>WOW School</title>\n"
		     		+ " <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n"
		     		+ "</head>\n"
		     		+ "<body>\n"
		     		+ "<div class=\"d-flex p-2 justify-content-center text-center\">\n"
		     		+ "<h1>WOW School Result Management System</h1>\n"
		     		+ "</div>\n"
		     		+ "<br>\n"
		     		+ "<div class=\"d-flex p-2 justify-content-center\">\n"
		     		+ "<p>Scan this code in Duo Mobile</p>\n"
		     		+ "</div>\n"
		     		+ "<div class=\"d-flex p-2 justify-content-center\">\n"
		     		+ "<img src="+barcode+">\n"
		     		+ "</div>\n"
		     		+ "<div class=\"d-flex p-2 justify-content-center\">\n"
		     		+ "<form action=\"duoEnrollStatus\" method=\"post\">\n"
		     		+ "<input type=\"hidden\" id=\"userid\" name=\"userid\" value="+userid+">\n"
		     		+ "<input type=\"hidden\" id=\"activation_code\" name=\"activation_code\" value="+actcode+">\n"
		     		+ "<input name=\"submit\" type=\"submit\" value=\"Click to Confirm\" class=\"btn btn-primary\">\n"
		     		+ "</form>\n"
		     		+ "</div>\n"
		     		+ "</body>\n"
		     		+ "</html>");

	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	}

}
