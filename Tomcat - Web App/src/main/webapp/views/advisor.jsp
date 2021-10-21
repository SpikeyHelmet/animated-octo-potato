<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW School - Advisor</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="d-flex p-2 justify-content-center text-center">
    <h1>Class Result</h1>
    </div>
	<form action="${pageContext.request.contextPath}/advisor" style="width:400px;margin-left: auto;margin-right:auto;" method="post">
  <div class="form-group row">
    <label for="dept" class="col-4 col-form-label">Faculty ID</label> 
    <div class="col-8">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text">
            <i class="fa fa-mortar-board"></i>
          </div>
        </div> 
        <input id="facultyid" name="facultyid" placeholder="1" type="text" class="form-control">
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
    <div style="margin-left: auto;margin-right:auto;">
      <input name="submit" type="submit" value="Get Marks" class="btn btn-primary">
    </div>
  </div>
	</form>
</body>
<div class="d-flex justify-content-center p-2"><a href="${pageContext.request.contextPath}/logout" role="button" class ="btn mr-md-2 mb-md-0 mb-2 btn-success btn-round">Logout</a></div>
</html>