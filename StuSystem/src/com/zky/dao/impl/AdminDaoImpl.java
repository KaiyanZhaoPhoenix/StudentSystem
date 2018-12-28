package com.zky.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.zky.bean.Admin;
import com.zky.dao.AdminDao;
import com.zky.utils.DBUtil;

public class AdminDaoImpl implements AdminDao{
	
	@Override
	public Admin findAdminByIDAndPassword(Admin admin,String className) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin ad = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("SELECT * FROM admins WHERE adminname=? and password=?");
			ps.setString(1, admin.getAdminname());
			ps.setString(2, admin.getPassword());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				ad = new Admin();
				ad.setId(rs.getInt(1));
				ad.setAdminname(rs.getString(2));
				ad.setPassword(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return ad;
	}

}
