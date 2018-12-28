package com.zky.service;

import com.zky.bean.User;

public interface UserService {
	public User findUserByIDAndPassword(User user,String className) throws Exception;
	public void updateUser(User user,String className) throws Exception;
	public void insertUser(User user,String className) throws Exception;

}
