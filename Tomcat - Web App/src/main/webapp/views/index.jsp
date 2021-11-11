<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW School - Portal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
</head>
<body>

<% Cookie[] cookies = request.getCookies();
boolean flag = false;
if (cookies != null) {
    for (Cookie cookie : cookies) {
    	if(cookie.getValue().equals("Authenticated")){
    		flag=true;
%>
	<div class="defaultSVG">
		<br>
		<br>
		<div class="d-flex justify-content-between">
		<div>
		<a href="${pageContext.request.contextPath}/logout" role="button" class ="text-hide">Logout</a>
		</div>
		
		<div class="text-center">
			<h1 class="text-white">
		        WOW SCHOOL RESULTS PORTAL
		    </h1>
		    <p class="text-white">
		    Welcome <%= request.getRemoteUser()	%>
		    </p>
		 </div>
		    <div>
		    	<a href="${pageContext.request.contextPath}/logout" role="button" class ="btn mr-md-2 mb-md-0 mb-2 btn-success btn-round">Logout</a>
		    </div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="authbox2">
			    <div class="d-flex p-10 justify-content-around">
			    <%if(request.isUserInRole("admin"))
			    {
			    	out.println("<a href=\"admininsert.jsp\" role=\"button\" class =\"myButton\">Enter Marks</a> <a href=\"adminviewmarks.jsp\" role=\"button\" class =\"myButton\">View Marks</a> <a href=\"adminUpdate.jsp\" role=\"button\" class =\"myButton\">Update Marks</a>");
			    }else if(request.isUserInRole("hod"))
			    {
			    	out.println("<a href=\"hod.jsp\" role=\"button\" class =\"btn mr-md-2 mb-md-0 mb-2 btn-primary btn-round\">Head Of Department</a>");
			    }else if(request.isUserInRole("advisor"))
			    {
			    	out.println("<a href=\"advisor.jsp\" role=\"button\" class =\"btn mr-md-2 mb-md-0 mb-2 btn-primary btn-round\">Advisor</a>");	
			    }else if(request.isUserInRole("faculty"))
			    {
			    	out.println("<a href=\"faculty.jsp\" role=\"button\" class =\"btn mr-md-2 mb-md-0 mb-2 btn-primary btn-round\">Faculty</a>");	
			    }else if(request.isUserInRole("student"))
			    {
			    	out.println("<a href=\"student.jsp\" role=\"button\" class =\"btn mr-md-2 mb-md-0 mb-2 btn-primary btn-round\">View Your Results</a>");	
			    }
			    %>
			  </div>
		</div>
    </div>
    
    <% 		}
    }
    
    if(flag==false)
    {
    out.println("<h1>Error You Did Not 2FA Authenticate!<h1>");
    }
} %>

</body>
</html>

