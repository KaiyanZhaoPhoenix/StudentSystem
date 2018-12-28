package com.zky.servlet;

import com.zky.bean.Student;
import com.zky.service.StudentService;
import com.zky.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//����ҵ���߼�
		StudentService studentService = new StudentServiceImpl();
		String student_id = request.getParameter("id");
		String student_name = request.getParameter("name");
		Student stu = new Student();
		Student student = stu;
		HttpSession session = request.getSession();
		String className=(String)session.getAttribute("className");
		List<Student> students = new ArrayList<Student>();
		try {
			if (student_id.trim().equals("")) {
				if (student_name.trim().equals("")) {
					request.setAttribute("msg_find", "The ID or Name Cann't be null.");
					request.getRequestDispatcher("findStudent.jsp").forward(request, response);
					return;
				}else {
					stu.setName(student_name);
					students = studentService.findStudentByName(stu,className);
				}	
			}else {
				if (student_name.trim().equals("")) {
					stu.setId(student_id);
					student = studentService.findStudentByID(stu,className);
					students.add(student);
				}else {
					stu.setId(student_id);
					stu.setName(student_name);
					student = studentService.findStudentByIDAndName(stu,className);
					students.add(student);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("students", students);
		// �ַ�ת��
        response.getWriter().write("Find successfully!");
        request.getRequestDispatcher("findStudentShow.jsp").forward(request, response);
	}

}
