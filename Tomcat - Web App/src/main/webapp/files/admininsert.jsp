<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW School - Admin</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="d-flex p-2 justify-content-center text-center">
    <h1>Insert Student Marks</h1>
    </div>
	<form action="${pageContext.request.contextPath}/insert" method="post">
	<div class="form-group row">
    <label class="col-4 col-form-label" for="studentid">Student ID</label> 
    <div class="col-8">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text">
            <i class="fa fa-address-card"></i>
          </div>
        </div> 
        <input id="studentid" name="studentid" placeholder="1" type="text" class="form-control">
      </div>
    </div>
  </div>
  <div class="form-group row">
    <label for="dept" class="col-4 col-form-label">Department Name</label> 
    <div class="col-8">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text">
            <i class="fa fa-mortar-board"></i>
          </div>
        </div> 
        <input id="dept" name="dept" placeholder="CSE" type="text" class="form-control">
      </div>
    </div>
  </div>
  <div class="form-group row">
    <label for="subjectid" class="col-4 col-form-label">Subject ID</label> 
    <div class="col-8">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text">
            <i class="fa fa-book"></i>
          </div>
        </div> 
        <input id="subjectid" name="subjectid" type="text" class="form-control">
      </div>
    </div>
  </div>
  <div class="form-group row">
    <label for="marks" class="col-4 col-form-label">Mark</label> 
    <div class="col-8">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text">
            <i class="fa fa-percent"></i>
          </div>
        </div> 
        <input id="marks" name="marks" placeholder="78" type="text" class="form-control">
      </div>
    </div>
  </div> 
  <div class="form-group row">
    <div class="offset-4 col-8">
      <input name="submit" type="submit" value="Call Servlet" class="btn btn-primary">
    </div>
  </div>
	</form>
</body>
</html>