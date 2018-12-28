package com.zky.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBUtil {
	private static String driverClass;
    private static String url;
    private static String username;
    private static String password;
    //url=jdbc:mysql://localhost:3306/1604?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
    
    public static Connection getConnection(String className) throws SQLException{
    	
    	String url_head = "jdbc:mysql://localhost:3306/";
		String url_last ="?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Hongkong";
    	ResourceBundle rBundle = ResourceBundle.getBundle("db");
    	driverClass = rBundle.getString("driverClass");
    	url = url_head + className + url_last;
		System.out.println(url);
    	username = rBundle.getString("username");
    	password = rBundle.getString("password");
    	try {
			//注册驱动
    		Class.forName(driverClass);
    		System.out.println("连接成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
 
    		return DriverManager.getConnection(url, username, password);
	}
    
   /* public static void main(String[] args) {
        DBUtil a=new DBUtil();
        try {
            a.getConnection();
            System.out.println("测试连接数据库，连接成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("测试连接数据库，连接失败");
        }
    }*/
}
