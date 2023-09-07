<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
   	<style type="text/css">
		<%@ include file="/views/css/menu_style.css"%>
.heading {
  text-align: center;
  font-size: 24px;
}

.textbox {
  width: 200px;
  height: 30px;
  border: 1px solid black;
  padding: 10px;
}

.button {
  background-color: blue;
  color: white;
  padding: 10px;
  border: none;
}
	</style>
      <meta charset="utf-8">
      <title>Responsive Navigation Menu</title>
      <link rel="stylesheet" href="/views/css/menu_style.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
   <body>   
      <nav>
         <div class="logo">
            Online Parking System
         </div>
         <label for="click" class="menu-btn">
         <i class="fas fa-bars"></i>
         </label>
         <ul>
            <li><a href="/Admin_Home">Home</a></li>
            <li><a class="active" href="/Parking_Cost">Parking Cost</a></li>
            <li><a href="/userDetails">User Details</a></li>
            <li><a href="/viewBook">View Booking</a></li>
            <li><a href="#">Admin</a></li>
            <li><a href="/">Logout</a></li>
         </ul>
      </nav>
     
      <div class="content">
      <form action="/setparkcost">
		<h1 class="heading">Set Parking Cost</h1><br>
		<input type="number" class="textbox" name="cost" placeholder="Enter parking Cost" maxlength="10" style="border: 1px solid black; padding: 10px;" value="${park_cost}">&nbsp;
		<input type="submit" class="button" value="Submit" style="background-color: blue; color: white; padding: 10px;"><br><br>
	 </form>
          <div><img alt="park" src="/views/images/park.jpg" width=70%> </div>
      </div>
      <div>${PrintSwal}</div>
   </body>
</html>
