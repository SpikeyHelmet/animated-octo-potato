<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW School - Admin</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <div class="d-flex p-2 justify-content-center text-center">
    <h1>Admin Dashboard</h1>
    <%
	String username = request.getRemoteUser();
	%>

    </div>
    <div class="d-flex p-2 justify-content-center text-center">
        <h2>Welcome <%= username %>!</h2>
    </div>
    <br>
    <div class="d-flex flex-column justify-content-center">
    <div class="d-flex justify-content-center p-2"><a href="admininsert.jsp" role="button" class ="btn mr-md-2 mb-md-0 mb-2 btn-danger btn-round">Enter Student Marks</a></div>
    <div class="d-flex justify-content-center p-2"><a href="adminviewmarks.jsp" role="button" class ="btn mr-md-2 mb-md-0 mb-2 btn-danger btn-round">View Student Marks</a></div>
    <div class="d-flex justify-content-center p-2"><a href="adminUpdate.jsp" role="button" class ="btn mr-md-2 mb-md-0 mb-2 btn-danger btn-round">Update Student Marks</a></div>
    <div class="d-flex justify-content-center p-2"><a href="${pageContext.request.contextPath}/logout" role="button" class ="btn mr-md-2 mb-md-0 mb-2 btn-success btn-round">Logout</a></div>
  </div>
</body>
</html>