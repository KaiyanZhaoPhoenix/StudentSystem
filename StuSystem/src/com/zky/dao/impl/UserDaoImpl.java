package com.zky.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zky.bean.User;
import com.zky.dao.UserDao;
import com.zky.utils.DBUtil;

public class UserDaoImpl implements UserDao{
	@Override
	public User findUserByIDAndPassword(User user,String className) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("SELECT * FROM user WHERE username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				u = new User();
			
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
			}
		} catch (Exception e) {
			
		}
		return u;
	}
	
	@Override
	public void updateUser(User user,String className) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("UPDATE user SET username=? and password=? WHERE id = ?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("¸üÐÂÊ§°Ü!");
		}
	}

	@Override
	public void insertUser(User user,String className) throws Exception{
		Connection conn = null ;
		PreparedStatement ps =null ;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("INSERT INTO user(id,username,password) VALUES (?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Ìí¼ÓÊ§°Ü!");
		}
		
	}
}
