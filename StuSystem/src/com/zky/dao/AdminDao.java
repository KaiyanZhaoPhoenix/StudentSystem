package com.zky.dao;

import com.zky.bean.Admin;

public interface AdminDao {
	public Admin findAdminByIDAndPassword(Admin admin,String className) throws Exception;
}
