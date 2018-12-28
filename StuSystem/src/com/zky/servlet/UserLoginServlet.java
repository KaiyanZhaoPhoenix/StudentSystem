package com.zky.servlet;

import com.zky.bean.Student;
import com.zky.bean.User;
import com.zky.service.UserService;
import com.zky.service.impl.UserServiceImpl;
import com.zky.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		
		User user = new User();
		UserService userService =new UserServiceImpl();
	
		String user_name = request.getParameter("student_name_log");
		String user_password = request.getParameter("student_password_log");
		String className=request.getParameter("optionsRadios");
		HttpSession session = request.getSession();
		session.setAttribute("className", className);
		user.setUsername(user_name);
		user.setPassword(user_password);
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = DBUtil.getConnection(className);
			ps = conn.prepareStatement("SELECT * FROM student WHERE id=?");
			ps.setString(1,user_name);
			rs = ps.executeQuery();
			if (rs.next()) {
		    stu = new Student();
			stu.setId(rs.getString(1)); // �õ�ID
			stu.setYear(rs.getString(2));
			stu.setClasss(rs.getString(3));
			stu.setName(rs.getString(4));
			stu.setStudyyear(rs.getInt(5));	
			stu.setPhonecall(rs.getString(6));}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��֤����
		if(user_name.equals("") || user_password.equals("")){  
	           request.setAttribute("msg", "please input the ID or password!");
	           request.getRequestDispatcher("index.jsp").forward(request, response);  
	           return;  
	    }   
		
		try {
			User u = userService.findUserByIDAndPassword(user,className);
			
			//�ַ�ת��
			if (u != null) {
				//�����¼�ɹ����Ͱ�student����ŵ�session������
				request.getSession().setAttribute("student", stu);
				request.getRequestDispatcher("/student_home.jsp").forward(request, response);
			} else {
				 request.setAttribute("msg", "the ID or password is wrong!");  
				 request.getRequestDispatcher("/index.jsp").forward(request, response);  
				 return;  
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
