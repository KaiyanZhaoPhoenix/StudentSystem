package com.zky.service.impl;

import com.zky.bean.Admin;
import com.zky.dao.AdminDao;
import com.zky.dao.impl.AdminDaoImpl;
import com.zky.service.AdminService;


public class AdminServiceImpl implements AdminService{
	AdminDao adminDao = new AdminDaoImpl();
	@Override
	public Admin findAdminByIDAndPassword(Admin admin,String className) throws Exception {
		return adminDao.findAdminByIDAndPassword(admin,className);
	}
}
