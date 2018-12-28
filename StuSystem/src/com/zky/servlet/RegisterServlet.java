package com.zky.servlet;

import com.zky.bean.User;
import com.zky.service.UserService;
import com.zky.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		User user = new User();
		user.setId(0);
		user.setUsername(request.getParameter("student_name_reg"));
		user.setPassword(request.getParameter("student_password_reg"));
		HttpSession session = request.getSession();
		String className=(String)session.getAttribute("className");
		
		UserService userService = new UserServiceImpl();
		try {
			User result = userService.findUserByIDAndPassword(user,className);
			
			if (result != null) {
				request.setAttribute("msg_re", "This account already exists.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			} else {
				userService.insertUser(user,className);
	            response.getWriter().write("Sign up successfully!");
	            request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
