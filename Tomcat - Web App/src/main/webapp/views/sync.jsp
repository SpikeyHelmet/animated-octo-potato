<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>WOW School - AD Sync</title>
    <link
      rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link
      rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.css"/>
    <link 
      rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
  </head>
  <body>
	<div class="authSVG">
		<br>
		<br>
		<div class="d-flex justify-content-center">
		    <h1 class="text-white">
		        WOW SCHOOL RESULTS PORTAL
		    </h1>
		</div>
		<br>
		<br>
		<br>
		<br>
		<div class="authbox1">
		<div>
		    <h2 class="text-center">Sync Active Directory</h2>
		    <p class="text-center">Kindly enter the Domain and Admin credentials to sync database records.</p>
		</div>
		<br><br>
		<div>
		<form class="authboxS1" action="${pageContext.request.contextPath}/ADSync" method="POST">
		    <div class="form-group">
		    <label class="font-weight-bold">Username</label>
		    <input type="text" class="formInput form-control" id="username" name="username">
		    </div>
		    <br>
		    <div class="form-group">
		    <label class="font-weight-bold">Password</label>
		    <input type="password" class="formInput form-control" id="password" name="password">
		    </div>
		    <br>
		    <div class="form-group">
		    <label class="font-weight-bold">Domain</label>
		    <input type="text" class="formInput form-control" id="domain" name="domain">
		    </div>
		    <br>
		    <div class="form-group">
		    <label class="font-weight-bold">Base</label>
		    <input type="text" class="formInput form-control" id="base" name="base">
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