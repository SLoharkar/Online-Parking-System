<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
   	<style type="text/css">
		<%@ include file="/views/css/menu_style.css"%>
		
}
	</style>
      <meta charset="utf-8">
      <title>Menu</title>
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
            <li><a class="active" href="/Admin_Home">Home</a></li>
            <li><a href="/Parking_Cost">Parking Cost</a></li>
            <li><a href="/userDetails">User Details</a></li>
            <li><a href="/viewBook">View Booking</a></li>
            <li><a href="#">Admin</a></li>
            <li><a href="/">Logout</a></li>
         </ul>
      </nav>
     
      <div class="content">
          <div><img alt="park" src="/views/images/park.jpg" width=70%> </div>
      </div>
      <div>${PrintSwal}</div>
   </body>
</html>
