<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>WOW School - Advisor</title>
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
    <div class="defaultSVG">
      <br />
      <br />
      <div class="d-flex justify-content-center">
        <h1 class="text-white">WOW RESULTS - ADVISOR DASHBOARD</h1>
      </div>
      <br />
      <br />
      <br />
      <br />
      <div class="authbox1">
        <div>
          <h2 class="text-center">View Class Marks</h2>
        </div>
        <br /><br />
        <div>
          <form
            class="authboxS1"
            action="${pageContext.request.contextPath}/advisor"
            method="POST"
          >
            <div class="form-group">
              <label class="font-weight-bold">Faculty ID</label>
              <input
                id="facultyid"
                name="facultyid"
                placeholder="1"
                type="text"
                class="formInput form-control"
              />
            </div>
            <div class="form-group">
              <label class="font-weight-bold">Department Name</label>
              <input
                id="dept"
                name="dept"
                placeholder="CSE"
                type="text"
                class="formInput form-control"
              />
            </div>
            <br /><br />
            <div class="text-center">
              <input
                type="submit"
                value="Submit"
                class="myButton"
                name="submit"
                placeholder="Submit"
              />
            </div>
            <br />
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
