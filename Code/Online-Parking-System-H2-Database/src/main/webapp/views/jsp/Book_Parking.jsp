<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
   	<style type="text/css">
		<%@ include file="/views/css/menu_style.css"%>
		
form {
  width: 500px;
  margin: 0 auto;
  background-color: #f5f5f5;
  padding: 20px;
}

h1 {
  text-align: center;
  font-size: 24px;
}

input {
  width: 200px;
  padding: 10px;
  border: 1px solid black;
}

label {
  font-size: 16px;
}

select {
  width: 200px;
  padding: 10px;
  border: 1px solid black;
}

input[type="submit"] {
  background-color: blue;
  color: white;
  padding: 10px;
  border: none;
}

.vehicle-number {
  margin-bottom: 10px;
}

.select-date {
  margin-bottom: 10px;
}

.parking-time {
  margin-bottom: 10px;
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
            <li><a href="/User_Home">Home</a></li>
            <li><a class="active" href="/bookParking">Book Parking</a></li>
            <li><a href="/yourBooking">Your Booking</a></li>
            <li><a href="#">${User}</a></li>
            <li><a href="/">Logout</a></li>
         </ul>
      </nav>
     
      <div class="content">
      
       <br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
      <form action="/book-parking-slot" method="post">
  		<h1>Book Parking Slot</h1><br><br>
  	
  		<label for="park_id">Parking Id</label>
 	    &ensp; &emsp; &emsp;&ensp; &emsp; &emsp; &ensp; 
 	    <input type="text" id="park_id" name="park_id1" value="${Park_id}" disabled><br></br>
  	
  	
  		<label for="vehicle_number">Vehicle Number</label>
 	    &ensp; &emsp; &emsp; &ensp; 
 	    <input type="text" id="vehicle_number" value="KP-12-1234" name="vehicle_number" placeholder="Enter vehicle number"><br></br>

  		<label for="select_date">Select Date</label>
  		&ensp; &ensp; &emsp; &emsp;&emsp; &ensp; 
  		<input type="date" id="select_date" name="start_date" value="2023-09-06"><br></br>

		<label for="park_cost">Parking Cost Per Hours</label>
 	    &ensp; 
 	    <input type="text" id="park_cost" name="park_cost1" value="${Park_cost}" disabled><br></br>

  		<label for="parking_time">Parking Time</label>
  		&emsp; &emsp; &ensp; &ensp; &ensp; 
  		<select id="parking_time" name="parking_end_time"><br></br>
    		<option value="1">1 Hours</option>
    		<option value="2">2 Hours</option>
    		<option value="3" selected>3 Hours</option>
    		<option value="4">4 Hours</option>
    		<option value="5">5 Hours</option>
  		</select><br>


  		<div>${Out}</div><br>

  	<input type="submit" value="Book Slot">
  	
</form>
      
      
      
          <div><img alt="park" src="/views/images/park.jpg" width=70%> </div>
      </div>
      <div>${PrintSwal}</div>
   </body>
</html>




