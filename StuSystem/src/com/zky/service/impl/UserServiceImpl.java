package com.zky.service.impl;

import com.zky.bean.User;
import com.zky.dao.UserDao;
import com.zky.dao.impl.UserDaoImpl;
import com.zky.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	public User findUserByIDAndPassword(User user,String className) throws Exception{
		return userDao.findUserByIDAndPassword(user,className);
	}
	public void updateUser(User user,String className) throws Exception{
		userDao.updateUser(user,className);
	}
	public void insertUser(User user,String className) throws Exception{
		userDao.insertUser(user,className);
	}
}
