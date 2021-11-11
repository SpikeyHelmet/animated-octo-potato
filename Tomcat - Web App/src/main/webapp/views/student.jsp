<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW School - Student</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
</head>
<body>
	<div class="defaultSVG">
		<br>
		<br>
		<div class="d-flex justify-content-center">
		    <h1 class="text-white">
		        WOW RESULTS - STUDENT DASHBOARD
		    </h1>
		</div>
		<br>
		<br>
		<br>
		<br>
		<div class="authbox1">
		<div>
		    <h2 class="text-center">View Semester Results</h2>
		</div>
		<br><br>
		<div>
		<form class="authboxS1" action="${pageContext.request.contextPath}/student" method="POST">
			<div class="form-group">
		    <label class="font-weight-bold">Student ID</label>
        	<input id="studentid" name="studentid" placeholder="1" type="text" class="formInput form-control">
		    </div>
		    <div class="form-group">
		    <label class="font-weight-bold">Department Name</label>
		    <input id="dept" name="dept" placeholder="CSE" type="text" class="formInput form-control">
		    </div>
		    <br><br>
		    <div class="text-center">
		    <input type="submit" value="Submit" class="myButton" name="submit" placeholder="Submit">
		    </div>
		    <br>
		</form>
		</div>
		</div>
    </div>
</body>
</html>