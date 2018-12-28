package com.zky.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zky.bean.Student;
import com.zky.dao.StudentDao;
import com.zky.utils.DBUtil;

public class StudentDaoImpl implements StudentDao{
	@Override
	public void addStudent(Student student,String className) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection(className);
		try {
			if(className.equals("1604")) {
			ps = conn.prepareStatement("INSERT INTO Student(id,year,classs,name,studyyear,phonecall) VALUES (?,?,?,?,?,?)");
			ps.setString(1, student.getId());
			ps.setString(2, student.getYear());
			ps.setString(3, student.getClasss());
			ps.setString(4, student.getName());
			ps.setInt(5, student.getStudyyear());
			ps.setString(6, student.getPhonecall());
			ps.executeUpdate();
			}else if (className.equals("1601")) {
				ps = conn.prepareStatement("INSERT INTO Student(id,stu_id,sex,address,dormitory,qq_num,stu_class) VALUES (?,?,?,?,?,?,?)");
				ps.setInt(1, student.getId1());
				ps.setString(2, student.getStu_id());
				ps.setString(3, student.getSex());
				ps.setString(4, student.getAddress());
				ps.setString(5, student.getDormitory());
				ps.setString(6, student.getQq_num());
				ps.setString(7, student.getStu_class());
				ps.executeUpdate();
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败!");
		}
	}

	@Override
	public Student findStudentByID(Student student,String className) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("SELECT * FROM student WHERE id=?");
			ps.setString(1, student.getId());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				stu = new Student();
				stu.setId(rs.getString(1)); // 得到ID
				stu.setYear(rs.getString(2));
				stu.setClasss(rs.getString(3));
				stu.setName(rs.getString(4));
				stu.setStudyyear(rs.getInt(5));	
				stu.setPhonecall(rs.getString(6));
			}
		} catch (Exception e) {
			
		}
		return stu;
	}
	
	@Override
	public ArrayList<Student> findStudentByName(Student student,String className) throws Exception {
		ArrayList<Student> students = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("SELECT * FROM student WHERE name=?");
			ps.setString(1, student.getName());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Student stu  = new Student();
				stu.setId(rs.getString(1)); // 得到ID
				stu.setYear(rs.getString(2));
				stu.setClasss(rs.getString(3));
				stu.setName(rs.getString(4));
				stu.setStudyyear(rs.getInt(5));	
				stu.setPhonecall(rs.getString(6));
				students.add(stu);
			}
		} catch (Exception e) {
			
		}
		return students;
	}
	
	@Override
	public Student findStudentByIDAndName(Student student,String className) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("SELECT * FROM student WHERE id=? and name=?");
			ps.setString(1, student.getId());
			ps.setString(2, student.getName());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				stu = new Student();
				stu.setId(rs.getString(1)); // 得到ID
				stu.setYear(rs.getString(2));
				stu.setClasss(rs.getString(3));
				stu.setName(rs.getString(4));
				stu.setStudyyear(rs.getInt(5));	
				stu.setPhonecall(rs.getString(6));
			}
		} catch (Exception e) {
			
		}
		return stu;
	}

	@Override
	public void updateStudent(Student student,String className) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			System.out.println("准备更新111");
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("UPDATE student SET year=?,classs=?,name=?,studyyear=?,phonecall=? WHERE id = ?");
			ps.setString(6, student.getId());
			ps.setString(1, student.getYear());
			ps.setString(2, student.getClasss());
			ps.setString(3, student.getName());
			ps.setInt(4, student.getStudyyear());
			ps.setString(5, student.getPhonecall());
			System.out.println(ps);
			ps.executeUpdate();
			System.out.println("更新完成");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败!");
		}
	}


	@Override
	public void deleteStudent(Student student,String className) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("DELETE FROM student WHERE id=?");
			ps.setString(1, student.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败!");
		}
	}
}
