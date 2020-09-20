package com.app.dao;

import com.app.pojos.User;

public interface IUserDao 
{
   public User validateUser(String email , String password);
}
