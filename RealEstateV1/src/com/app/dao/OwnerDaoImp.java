package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Flats;
import com.app.pojos.User;

@Repository
@Transactional
public class OwnerDaoImp implements IOwnerDao
{
   @Autowired
   private SessionFactory sf;
   
   public Flats addFlatDetails(User u)
   {
	   sf.getCurrentSession().update(u);
	   return u;
   }
   
}










