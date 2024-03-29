<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>WOW School - Passcode</title>
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
    <div class="authSVG">
      <br />
      <br />
      <div class="d-flex justify-content-center">
        <h1 class="text-white">WOW SCHOOL RESULTS PORTAL</h1>
      </div>
      <br />
      <br />
      <br />
      <br />
      <div class="authbox1">
        <div>
          <h2 class="text-center">Authentication - 2FA</h2>
          <p class="text-center">
            Kindly enter your 6-digit Authentication code from Duo Mobile for
            SAML SSO.
          </p>
        </div>
        <br /><br />
        <div>
          <form
            class="authboxS1"
            action="${pageContext.request.contextPath}/duoAuth"
            method="post"
          >
            <div class="form-group">
              <label class="font-weight-bold">Passcode</label>
              <input
                id="passcode"
                name="passcode"
                placeholder="123123"
                type="text"
                class="formInput2 form-control"
              />
              <<<<<<< Updated upstream
              <input
                id="userid"
                name="userid"
                type="hidden"
                value="${userid}"
                class="form-control"
              />
              ======= <input id="userid" name="userid" type="hidden"
              value="<%=request.getParameter("userid")%>" class="form-control">
              >>>>>>> Stashed changes
            </div>
            <br /><br />
            <div class="text-center">
              <input
                type="submit"
                class="myButton"
                name="submit"
                placeholder="Enter Code"
              />
            </div>
            <br />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
