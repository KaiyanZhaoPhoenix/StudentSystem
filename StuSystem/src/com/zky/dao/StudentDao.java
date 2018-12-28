package com.zky.dao;

import java.util.ArrayList;

import com.zky.bean.Student;

public interface StudentDao {
	/**
	 * ���ѧ����Ϣ
	 * @param student ѧ��
	 * @throws Exception
	 */
	public void addStudent(Student student,String className) throws Exception;
	
	/**
	 * ����ѧ��ѧ�ź��������ѧ��
	 * @param student 
	 * @return
	 * @throws Exception
	 */
	/*public Student findStudentByIDAndPassword(Student student) throws Exception;*/
	
	/**
	 * ����ѧ��ѧ�Ų���ѧ��
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByID(Student student,String className) throws Exception;
	
	/**
	 * ����ѧ����������ѧ��
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Student> findStudentByName(Student student,String className) throws Exception;
	
	/**
	 * ����ѧ��ID����������ѧ��
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public Student findStudentByIDAndName(Student student,String className) throws Exception;
	
	/**
	 * ����ѧ������,��id��name��password
	 * @param student
	 * @throws Exception
	 */
	public void updateStudent(Student student,String className) throws Exception;
	
	/**
	 * ����ѧ��ȫ������
	 * @param student
	 * @throws Exception
	 */
//	public void updateStudentAll(Student student) throws Exception;
	
	/**
	 * ɾ��ѧ��
	 * @param student
	 * @throws Exception
	 */
	public void deleteStudent(Student student,String className) throws Exception;

}
