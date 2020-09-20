package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IOwnerDao;
import com.app.pojos.Flats;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/owner")
public class OwnerController
{
    @Autowired
    private IOwnerDao dao;
    
    @PostConstruct
    public void init()
    {
    	System.out.println("in init " + dao);
    }
    
    @PostMapping("/addflat")
    public ResponseEntity<?> addFlat(@RequestBody Flats f , HttpSession hs)
    {
    	System.out.println("in add Flat" + f);
    	User u  = (User)hs.getAttribute("user_details");
    	u.addFlat(f);
    	try
    	{
    		return new ResponseEntity<Flats>(f , HttpStatus.CREATED);
    	}
    	catch (RuntimeException e) {
    	   e.printStackTrace();
           return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}















