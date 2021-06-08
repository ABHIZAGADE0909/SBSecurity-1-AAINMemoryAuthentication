package com.abhay.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppTestController {

	@GetMapping("/home")
	public String  showHome()
	{
		return "Home";
	}
	
	@GetMapping("/profile")
	public String  showPofile()
	{
		return "Profile";
	}
	
	@GetMapping("/admin")
	public String  showAdmin()
	{
		return "Admin";
	}
	
	@GetMapping("/emp")
	public String  showEmployee()
	{
		return "Employee";
	}
	
	@GetMapping("/denied")
	public String  showDenied()
	{
		return "Denied";
	}
}
