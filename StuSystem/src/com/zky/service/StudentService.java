package com.zky.service;

import java.util.ArrayList;


import com.zky.bean.Student;


public interface StudentService {
	
	/**
	 * 添加学生信息
	 * @param student
	 * @throws Exception
	 */
	public void addStudent(Student student,String className) throws Exception;
	
	/**
	 * 根据学生ID和密码查找学生
	 * @param student
	 * @return 
	 * @throws Exception
	 */
	//public Student findStudentByIDAndPassword(Student student) throws Exception;
	
	/**
	 * 根据学生ID查找学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByID(Student student,String className) throws Exception;
	
	/**
	 * 根据学生姓名查找学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Student> findStudentByName(Student student,String className) throws Exception;
	
	/**
	 * 根据学生ID和姓名查找学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByIDAndName(Student student,String className) throws Exception;
	
	/**
	 * 更新学生部分信息
	 * @param student
	 * @throws Exception
	 */
	public void updateStudent(Student student,String className) throws Exception;
	
	/**
	 * 更新学生全部信息
	 * @param student
	 * @throws Exception
	 */
	//public void updateStudentAll(Student student) throws Exception;
	
	/**
	 * 删除学生
	 * @param student
	 * @throws Exception
	 */
	public void deleteStudent(Student student,String className) throws Exception;
}
