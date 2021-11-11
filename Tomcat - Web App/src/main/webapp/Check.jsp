<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW - School Portal</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    
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


</body>
</html>