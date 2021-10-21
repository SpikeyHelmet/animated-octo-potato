<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW - School Portal</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%

if(request.getRemoteUser() == null)
{
	out.println("<div class=\"d-flex justify-content-center p-2\"><a href=\"duoPreauth\" role=\"button\" class =\"btn mr-md-2 mb-md-0 mb-2 btn-success btn-round\">Auth</a></div>");
}
else
{
	out.println("<div class=\"d-flex justify-content-center p-2\"><a href=\"index.html\" role=\"button\" class =\"btn mr-md-2 mb-md-0 mb-2 btn-success btn-round\">Homepage</a></div>");
}
%>

</body>
</html>