<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WOW School - Passcode</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="d-flex p-2 justify-content-center text-center">
    <h1>Duo Passcode Verification</h1>
    </div>
	<form action="${pageContext.request.contextPath}/duoAuth" method="post" style="width:400px;margin-left: auto;margin-right:auto;">
  <div class="form-group row">
    <label for="passcode" class="col-4 col-form-label">Passcode</label> 
    <div class="col-8">
      <div class="input-group">
        <div class="input-group-prepend">
          <div class="input-group-text">
            <i class="fa fa-mortar-board"></i>
          </div>
        </div> 
        <input id="passcode" name="passcode" placeholder="123123" type="text" class="form-control">
              <input id="userid" name="userid" type="hidden" value ="${userid}" class="form-control">
      </div>
    </div>
  </div>
  <div class="form-group row">
    <div style="margin-left: auto;margin-right:auto;">
      <input name="submit" type="submit" value="Enter Code" class="btn btn-primary">
    </div>
  </div>
	</form>
	<div class="d-flex justify-content-center p-2"><a href="${pageContext.request.contextPath}/logout" role="button" class ="btn mr-md-2 mb-md-0 mb-2 btn-success btn-round">Logout</a></div>
</body>
</html>