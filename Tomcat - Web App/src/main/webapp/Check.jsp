<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW - School Portal</title>
    <link
      rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link
      rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.css"/>
    <link 
      rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    
</head>
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
<button class="myButton2">
<%

String prinrole = request.getRemoteUser();

if(prinrole == null)
{
	out.println("<a href=\"duoPreauth\" role=\"button\">Auth</a>");
}
else
{
	out.println("<a href=\"views/index.jsp\" role=\"button\">Homepage</a>");
}
%>


</button>
</div>
<div class="d-flex justify-content-center p-2">
<button class="myButton2">
	<a href="views/sync.jsp" role="button">Sync Roles</a>
</button>
</div>

</body>
</html>