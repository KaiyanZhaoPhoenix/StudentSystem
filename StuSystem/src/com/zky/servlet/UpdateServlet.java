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

/**
 * Servlet implementation class UpdateServlet
*/
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		HttpSession session = request.getSession();
		String className=(String)session.getAttribute("className");
		//����ҵ���߼�
		StudentService studentService = new StudentServiceImpl();
		String student_id = request.getParameter("id");
		Student stu = new Student();
		stu.setId(student_id);
		Student student = stu;
		try {
			student = studentService.findStudentByID(stu,className);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String year = request.getParameter("year");
		String classs = request.getParameter("class");
		String name = request.getParameter("name");
		String studyyear = request.getParameter("studyyear");
		String phonecall = request.getParameter("phonecall");
		if (!id.trim().equals("")) {
			student.setId(id);
		}
		if (!year.trim().equals("")) {
			student.setYear(year);
		}
		if (!classs.trim().equals("")) {
			student.setClasss(classs);
		}
		
		if (!name.trim().equals("")) {
			student.setName(name);		
		}
		if (!studyyear.trim().equals("")) {
			student.setStudyyear(Integer.valueOf(studyyear));
		}
		if (!phonecall.trim().equals("")) {
			student.setPhonecall(phonecall);
		}
		
		
		try {
			System.out.println("׼������");
			studentService.updateStudent(student,className);
			System.out.println("���½���");
			// �ַ�ת��
	        response.getWriter().write("Modified successfully!");
	        request.getRequestDispatcher("updateStudent.jsp?stu_id="+student_id).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
