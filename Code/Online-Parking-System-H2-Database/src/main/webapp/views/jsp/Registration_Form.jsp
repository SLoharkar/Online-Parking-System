<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="/views/css/reg_style.css">
    <!-- Fontawesome CDN Link For Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
  </head>
  <body>
    <form action="/User_Registration" method="post">
      <h2>Registration Form</h2>
      <div class="form-group fullname">
        <label for="fullname">Full Name</label>
        <input type="text" id="fullname" name="fullname" value="Test Account" placeholder="Enter your full name">
      </div>
      <div class="form-group email">
        <label for="email">Email Address</label>
        <input type="text" id="email" name="email" value="Test@email.com" placeholder="Enter your email address">
      </div>
      <div class="form-group password">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="Test" placeholder="Enter your password">
        <i id="pass-toggle-btn" class="fa-solid fa-eye"></i>
      </div>
      <div class="form-group date">
        <label for="date">Birth Date</label>
        <input type="date" id="date" name="date" value="1999-12-01" placeholder="Select your date">
      </div>
      <div class="form-group gender">
        <label for="gender">Gender</label>
        <select id="gender" name="gender">
          <option value="" selected disabled>Select your gender</option>
          <option value="Male" selected>Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div>
      <div class="form-group submit-btn">
        <input type="submit" value="Submit">
      </div>
      <div>
        <h3>Already have an account? <a href="/Login">Login now</a></h3>
      </div>
    </form>
<div>${PrintSwal}</div>
    <script src="/views/javascript/reg_script.js"></script>
  </body>
</html>