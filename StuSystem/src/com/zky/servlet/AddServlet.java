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
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		
		
		Student student = new Student();
		String id = request.getParameter("id");
		String year = request.getParameter("year");
		String classs = request.getParameter("class");
		String name = request.getParameter("name");
		String studyyear = request.getParameter("studyyear");
		String phonecall = request.getParameter("phonecall");
		
		student.setId(id);
		student.setYear(year);
		student.setClasss(classs);
		student.setName(name);
		student.setStudyyear(Integer.valueOf(studyyear));
		student.setPhonecall(phonecall);
		
		HttpSession session = request.getSession();
		String className=(String)session.getAttribute("className");
		
		
		StudentService studentService = new StudentServiceImpl();
		try {
			
			Student result = studentService.findStudentByID(student,className);
			 
			if (result != null) {
				request.setAttribute("msg_add", "This account already exists.");
				request.getRequestDispatcher("addStudent.jsp").forward(request, response);
				return;
			} else {
				
				studentService.addStudent(student,className);
	            response.getWriter().write("Add student successfully!");
	            request.getRequestDispatcher("admin_home.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
