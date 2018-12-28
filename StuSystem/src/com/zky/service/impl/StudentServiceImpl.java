package com.zky.service.impl;

import java.util.ArrayList;

import com.zky.bean.Student;
import com.zky.dao.StudentDao;
import com.zky.dao.impl.StudentDaoImpl;
import com.zky.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao studentDao = new StudentDaoImpl();
	@Override
	public void addStudent(Student student,String className) throws Exception {
		studentDao.addStudent(student,className);
	}
	
	/*@Override
	public Student findStudentByIDAndPassword(Student student) throws Exception {
		return studentDao.findStudentByIDAndPassword(student);
	}
*/
	@Override
	public Student findStudentByID(Student student,String className) throws Exception {
		return studentDao.findStudentByID(student,className);
	}

	@Override
	public ArrayList<Student> findStudentByName(Student student,String className) throws Exception {
		return studentDao.findStudentByName(student,className);
	}

	@Override
	public Student findStudentByIDAndName(Student student,String className) throws Exception {
		return studentDao.findStudentByIDAndName(student,className);
	}
	
	@Override
	public void updateStudent(Student student,String className) throws Exception {
		studentDao.updateStudent(student,className);
	}

	/*@Override
	public void updateStudentAll(Student student) throws Exception {
		studentDao.updateStudentAll(student);
	}*/

	@Override
	public void deleteStudent(Student student,String className) throws Exception {
		studentDao.deleteStudent(student,className);
	}

}
