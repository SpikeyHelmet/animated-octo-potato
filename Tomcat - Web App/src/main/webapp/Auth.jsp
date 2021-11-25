<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW School - 2FA</title>
    <link
      rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link
      rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.css"/>
    <link 
      rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    
</head>
<% Cookie[] cookies = request.getCookies();
boolean flag = false;
if (cookies != null) {
    for (Cookie cookie : cookies) {
    	if(cookie.getValue().equals("Authenticated")){
    		flag=true;
    	}
    }
    if(flag==false)
    {
%>
<body class="checkSVG">
<div class="d-flex justify-content-center p-2">
    <h1>
        WELCOME TO WOW SCHOOL RESULTS
    </h1>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="d-flex justify-content-center p-2">
   	<a href="${pageContext.request.contextPath}/duoPreauth" role="button" class ="myButton2">Duo Auth</a>
</div>
</body>
<% 	}else{
    out.println("<h1>Error you are already Authenticated!<h1>");
    }
} %>
</html>
