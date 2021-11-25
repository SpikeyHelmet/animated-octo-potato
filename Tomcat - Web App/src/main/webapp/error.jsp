<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>WOW School - Error</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/bootstrap.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/fontawesome.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/main.css"
    />
  </head>
  <body>
    <div class="d-flex justify-content-center p-2">
      <h1>WELCOME TO WOW SCHOOL RESULTS</h1>
    </div>
    <br />
    <br />
    <br />
    <br />
    <div class="d-flex justify-content-center p-2">
      <div>
        <h2 class="text-center">Invalid user name or password.</h2>

        <p class="text-center">
          Please enter a user name or password that is authorized to access this
          application.
          <br />
          Click to <a href="Auth.jsp">Try Again</a>
        </p>
      </div>
    </div>
  </body>
</html>
