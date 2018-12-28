package com.zky.service;

import com.zky.bean.Admin;

public interface AdminService {
	public Admin findAdminByIDAndPassword(Admin admin,String className) throws Exception;
}
