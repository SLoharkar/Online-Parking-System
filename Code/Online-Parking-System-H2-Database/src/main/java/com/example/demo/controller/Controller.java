package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.ParkingRegistration;
import com.example.demo.model.UserRegistration;
import com.example.demo.repository.ParkRepo;
import com.example.demo.repository.UserRepo;

//@Controller
@RestController
public class Controller {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	ParkRepo prepo;

	static public String user_session;
	static public int park_cost=20,randomNumber;
	
	@RequestMapping("/")
	public ModelAndView Menu()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Menu");
		return mv;
	}
	
	@RequestMapping("/Login")
	public ModelAndView Login(String print)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("PrintSwal",print);
		mv.setViewName("Login_Form");
		return mv;
	}
	
	@RequestMapping("/VerifyLogin")
	public ModelAndView VerifyLogin(String email, String password) 
	{
		ModelAndView mv = new ModelAndView("Login_Form");
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

		
		UserRegistration user = repo.findByEmailAndPassword(email, password);
		
		
		if(email.equals("admin") && password.equals("admin"))
		{
			print=print + "<script>swal('Admin Login Sucessfully');</script>";	
			mv.addObject("PrintSwal",print);
			user_session="Admin";
			mv.setViewName("Admin_View");
		}
		else if(user !=null)
		{
			print=print + "<script>swal('User Login Sucessfully');</script>";	
			mv.addObject("PrintSwal",print);
			mv.addObject("User",user.getFullname());
			user_session=user.getFullname();
			mv.setViewName("User_View");
		}
		else
		{
			print=print + "<script>swal('Sorry You entered an incorrect email or password');</script>";	
			mv.addObject("PrintSwal",print);
		}
		
		return mv;
	}
	
	
	
	@RequestMapping("/User")
	public ModelAndView User()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Registration_Form");
		return mv;
	}
	
	
	@RequestMapping("/User_Registration")
	public ModelAndView User_Registration(UserRegistration ureg,String email)
	{
		ModelAndView mv = new ModelAndView("Registration_Form");
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";
		
		
		//Find Data Using Email
		Optional<UserRegistration> ureg1 = repo.findById(email);
		
			
		if(ureg1.isPresent())
		{
			
			print=print + "<script>swal('User Already Exists');</script>";		

		}
		else
		{
			
			//Save Data in Student Registration Table
			
			repo.save(ureg);
			
			print=print + "<script>swal('Registration Successful');</script>";

			mv.addObject("PrintSwal",print);
			
			//mv.setViewName("Login_Form");
			return Login(print);

		}
		
		mv.addObject("PrintSwal",print);
		

		return mv;
	}
	
	@RequestMapping("/Admin_Home")
	public ModelAndView Admin_Home()
	{
		ModelAndView mv = new ModelAndView("Admin_View");
		return mv;
	}
	
	
	@RequestMapping("/Parking_Cost")
	public ModelAndView Parking_Cost_View()
	{
		ModelAndView mv = new ModelAndView("SetParkCost");
		mv.addObject("park_cost",park_cost);
		return mv;
	}
	
	@RequestMapping("/setparkcost")
	public ModelAndView setParkCost(Integer cost)
	{
		ModelAndView mv = new ModelAndView("SetParkCost");
	
		park_cost=cost;
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";
		print=print + "<script>swal('Parking Cost Set Sucessfully');</script>";	
		mv.addObject("PrintSwal",print);
		mv.addObject("park_cost",park_cost);
		return mv;
	}
	
	
	@RequestMapping("/userDetails")
	public ModelAndView userDetails()
	{
		ModelAndView mv = new ModelAndView("User_Details");
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

		List<UserRegistration> u1 = repo.findAll();
		
			if(u1.isEmpty())
			{			
				print=print + "<script>swal('Data Not Found');</script>";

				mv.addObject("PrintSwal",print);
				
				mv.setViewName("Admin_View");
			}
			else
			{
				String out="";
		
				for (UserRegistration user : u1) 
				{
					out=out+"<tr>"
					+"<td>"+user.getFullname()+"</td>"
					+"<td>"+user.getEmail()+"</td>"
					+"<td>"+user.getPassword()+"</td>"
					+"<td>"+user.getDate()+"</td>"
					+"<td>"+user.getGender()+"</td>"
					+"</tr>";
					mv.addObject("Out",out);		    
				}
			}
		

		return mv;
	}

	@RequestMapping("/viewBook")
	public ModelAndView viewBooking()
	{
		ModelAndView mv = new ModelAndView("View_Booking");
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

		List<ParkingRegistration> p1 = prepo.findAll();
				
			if(p1.isEmpty())
			{			
				print=print + "<script>swal('Data Not Found');</script>";

				mv.addObject("PrintSwal",print);
				
				mv.setViewName("Admin_View");
			}
			else
			{
				String out="";
		
				for (ParkingRegistration park : p1) 
				{
					out=out+"<tr>"
					+"<td>"+park.getUser()+"</td>"
					+"<td>"+park.getPark_id()+"</td>"
					+"<td>"+park.getVehicle_number()+"</td>"
					+"<td>"+park.getStart_date()+"</td>"
					+"<td>"+park.getParking_start_time()+"</td>"
					+"<td>"+park.getParking_end_time()+"</td>"
					+"<td>"+park.getSlotBook()+"</td>"
					+"<td>"+park.getPark_cost()+"</td>"
					+"</tr>";
					mv.addObject("Out",out);	
					
				}
			}

		
		
		return mv;
	}
	
	@RequestMapping("/User_Home")
	public ModelAndView User_Home()
	{
		ModelAndView mv = new ModelAndView("User_View");
		mv.addObject("User",user_session);
		return mv;
	}
	
	
	@RequestMapping("/bookParking")
	public ModelAndView Book_Parking(String print)
	{
		ModelAndView mv = new ModelAndView("Book_Parking");
		
		mv.addObject("User",user_session);

		mv.addObject("PrintSwal",print);
		
		List<ParkingRegistration> p1 = prepo.findAll();
		
		
			if(p1.isEmpty())
			{
				String out="<label for='slot_book'>Slots</label>"
				 	    +"&ensp;&ensp;&ensp;&emsp;&emsp;" 
				 	    +"<select id='slot_book' name='slotBook'><br></br>";
							
				for(int i=1; i<=5;i++)
				{
				out=out+"<option value='Slot "+i+"'>Slot "+i+"</option>";
				}
				
				out=out+"</select>";
				
				mv.addObject("Out",out);

			}
			else
			{
				String out="<label for='slot_book'>Slots</label>"
				 	    +"&ensp;&ensp;&ensp;&emsp;&emsp;" 
				 	    +"<select id='slot_book' name='slotBook'><br></br>";
					
					for(int i=1; i<=5;i++)
					{
							String f1="Slot "+i;
			
							ParkingRegistration pr = prepo.findBySlotBook(f1);
							
							if(pr!=null )
							{
								continue;
							}
													
							out=out+"<option value='"+f1+"'>"+f1+"</option>";	
					}
				
				out=out+"</select>";
				mv.addObject("Out",out);

			}
			
		
		Optional<ParkingRegistration> pr1 = prepo.findById(randomNumber);
		
		if(pr1.isPresent()){ randomNumber=(int) (Math.random() * 100) + 1; }
		else {randomNumber = (int) (Math.random() * 100) + 1;}
		
		mv.addObject("Park_id",randomNumber);
		mv.addObject("Park_cost",park_cost);
		
		return mv;
	}
	
	@RequestMapping("/book-parking-slot")
	public ModelAndView Book_parking_slot(ParkingRegistration preg, String slotBook,HttpServletResponse response)
	{
		
		ModelAndView mv = new ModelAndView("Book_Parking");
		
		mv.addObject("User",user_session);
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";
				
		if(slotBook==null)
		{
			print=print + "<script>swal('Sorry, parking slot not available');</script>";

			mv.addObject("PrintSwal",print);
			
		}
		else
		{
		LocalDateTime sTime = LocalDateTime.now();
	    LocalDateTime eTime = sTime.plusHours(Long.parseLong(preg.getParking_end_time()));

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
	    String start_time = formatter.format(sTime);
	    String end_time = formatter.format(eTime);

	    preg.setPark_cost(park_cost*Integer.parseInt(preg.getParking_end_time()));
		preg.setParking_start_time(start_time);
		preg.setParking_end_time(end_time);
		preg.setUser(user_session);
		preg.setPark_id(randomNumber);
	
		prepo.save(preg);
		
		print=print + "<script>swal('Booking successful');</script>";
		
		mv.addObject("PrintSwal",print);
		
		return Book_Parking(print);
		
		}
		
		return mv;
		
	}
	
	
	@RequestMapping("/yourBooking")
	public ModelAndView View_User_Booking()
	{
		ModelAndView mv = new ModelAndView("View_User_Booking");
		
		mv.addObject("User",user_session);
		
		String print="<script src='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js'></script>";

		
		try 
		{
			
		
		List<ParkingRegistration> p1 = prepo.findAll();
		
		List<ParkingRegistration> puser = prepo.findByUser(user_session);
	
		
			if(p1.isEmpty() || user_session.equals(null))
			{			
				print=print + "<script>swal('Data Not Found');</script>";

				mv.addObject("PrintSwal",print);
				
				mv.setViewName("User_View");
			}
			else if(puser.isEmpty())
			{
				print=print + "<script>swal('Data Not Found');</script>";

				mv.addObject("PrintSwal",print);
				
				mv.setViewName("User_View");
			}
			
			else //if(puser.getUser().equals(user_session))
			{
				String out="";
		
				for (ParkingRegistration park : p1) 
				{
					if(park.getUser().equals(user_session))
					{	
					out=out+"<tr>"
					+"<td>"+park.getPark_id()+"</td>"
					+"<td>"+park.getVehicle_number()+"</td>"
					+"<td>"+park.getStart_date()+"</td>"
					+"<td>"+park.getParking_start_time()+"</td>"
					+"<td>"+park.getParking_end_time()+"</td>"
					+"<td>"+park.getSlotBook()+"</td>"
					+"<td>"+park.getPark_cost()+"</td>"
					+"</tr>";
					mv.addObject("Out",out);	
					}
				}
			}
		}catch(Exception e)
		{
			//System.out.println(e);
			print=print + "<script>swal('Data Not Found Contact Administrator');</script>";

			mv.addObject("PrintSwal",print);
			mv.setViewName("User_View");
		}
		
		
		return mv;
	}
	
	
		
}
