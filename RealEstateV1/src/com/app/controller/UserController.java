package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.Role;
import com.app.pojos.User;

@Controller
@RequestMapping("/user")
public class UserController 
{
    @Autowired
    private IUserDao dao;
    
    @PostConstruct
    public void myInit()
    {
    	System.out.println("In Init of "+getClass().getName()+"dao is : "+dao);
    }
    
    @GetMapping("/login")
    public String showLoginForm()
    {
    	System.out.println("In show login form");
    	return "/user/login";
    }
    
    @PostMapping("/login")
    public String processLoginForm(@RequestParam String email , @RequestParam String password , Model map , HttpSession hs , RedirectAttributes flashMap) 
    {
  	  System.out.println("In process Login Form "+email+" "+password);
      
  	  try {
  		System.out.println("Inside try");
		User u = dao.validateUser(email, password);
		System.out.println("login successfull");
		flashMap.addFlashAttribute("msg", u.getUserRole() + "Login Successfull");
		hs.setAttribute("user_details", u);
		if (u.getUserRole().equals(Role.ADMIN)) {
			return "redirect:/admin/list";
		}
		else if (u.getUserRole().equals(Role.OWNER))
		{
			return "redirect:/owner/list";
		} 
		else {
			System.out.println("Buyer login ...redirecting");
			return "redirect:/buyer/list";
		} 
	} 
  	  catch (RuntimeException e)
  	  {
	     map.addAttribute("msg", "Invalid Login Retry");
	     return "/user/login";
  	  }
    }
}

















