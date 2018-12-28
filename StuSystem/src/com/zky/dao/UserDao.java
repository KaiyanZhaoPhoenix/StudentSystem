package com.zky.dao;

import com.zky.bean.User;

public interface UserDao {
	public User findUserByIDAndPassword(User user,String className) throws Exception;
	public void updateUser(User user,String className) throws Exception;
	public void insertUser(User user,String className) throws Exception;
}
