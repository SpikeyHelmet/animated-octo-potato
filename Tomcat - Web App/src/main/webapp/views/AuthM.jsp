<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		    <h2 class="text-center">Authentication - 2FA</h2>
		    <p class="text-center">Kindly Choose your Authentication Method</p>
		</div>
		<br><br>
		<div>
		<form class="" action="${pageContext.request.contextPath}/duoAuth" method="post">
		    <div class="d-flex p-10 justify-content-between">
			    <a href="${pageContext.request.contextPath}/views/passcode.jsp?userid=${userid}" role="button" class="myButton">Passcode</a>
			    <input id="userid" name="userid" type="hidden" value="${userid}">
			    <input type="submit" class="myButton" name="sms" value="sms" placeholder="SMS">
			    <input type="submit" class="myButton" name="push" value="push" placeholder="Push">
			    <input type="submit" class="myButton" name="phone" value="phone" placeholder="Phone">
		    </div>
		    <br>
		</form>
		</div>
		</div>
    </div>
	
</body>
</html>