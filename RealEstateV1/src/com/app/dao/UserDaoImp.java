package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;


@Repository
@Transactional
public class UserDaoImp implements IUserDao
{
	   @Autowired
	   private SessionFactory sf;
	   
	   public User validateUser(String email , String password)
	   {
		 System.out.println("Inside dao validate function");
		 String jpql = "Select u from User u where u.email=:em and u.password=:pass";  
		 return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", password).getSingleResult();
	   }
}






