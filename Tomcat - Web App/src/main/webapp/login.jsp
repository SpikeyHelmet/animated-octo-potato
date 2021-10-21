<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>WOW School - Login</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
  </head>
  <body>
    <div class="d-flex p-2 justify-content-center text-center">
      <h1>Authentication</h1>
    </div>
    <form
      action="j_security_check"
      style="width: 400px; margin-left: auto; margin-right: auto"
      method="post"
    >
      <div class="form-group row">
        <label class="col-4 col-form-label" for="studentid">Username</label>
        <div class="col-8">
          <div class="input-group">
            <div class="input-group-prepend">
              <div class="input-group-text">
                <i class="fa fa-address-card"></i>
              </div>
            </div>
            <input
              id="j_username"
              name="j_username"
              type="text"
              class="form-control"
            />
          </div>
        </div>
      </div>
      <div class="form-group row">
        <label for="dept" class="col-4 col-form-label">Password</label>
        <div class="col-8">
          <div class="input-group">
            <div class="input-group-prepend">
              <div class="input-group-text">
                <i class="fa fa-mortar-board"></i>
              </div>
            </div>
            <input
              id="j_password"
              name="j_password"
              type="text"
              class="form-control"
            />
          </div>
        </div>
      </div>
      <div class="form-group row">
        <div style="margin-left: auto; margin-right: auto">
          <input
            name="submit"
            type="submit"
            value="Submit"
            class="btn btn-primary"
          />
        </div>
      </div>
    </form>
  </body>
</html>