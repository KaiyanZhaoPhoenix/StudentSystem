package com.zky.servlet;

import com.zky.bean.Admin;
import com.zky.service.AdminService;
import com.zky.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Admin admin = new Admin();
		AdminService adminService = new AdminServiceImpl();
		String adminname = request.getParameter("adminname");
		String password = request.getParameter("password");
		String className = request.getParameter("optionsRadios");
		HttpSession session = request.getSession();
		session.setAttribute("className", className);
		admin.setAdminname(adminname);
		admin.setPassword(password);
	
		if(adminname.trim().equals("") || password.trim().equals("")){  
	           request.setAttribute("msg_admin", "please input the id or password!");
	           request.getRequestDispatcher("admin.jsp").forward(request, response);  
	           return;  
	    }   
		try {
			Admin ad = adminService.findAdminByIDAndPassword(admin,className);
	
			if( className.equals("1604")){
				if (ad != null) {
				
					request.getSession().setAttribute("admin", ad);
					request.getRequestDispatcher("/admin_home.jsp").forward(request, response);
				} else {
					 request.setAttribute("msg_admin", "the ID or password is wrong!");  
					 request.getRequestDispatcher("/admin.jsp").forward(request, response);  
					 return;  
				}
			}else if(className.equals("1603")) {
				if (ad != null) {
					
					request.getSession().setAttribute("admin", ad);
					request.getRequestDispatcher("/admin_home3.jsp").forward(request, response);
				} else {
					 request.setAttribute("msg_admin", "the ID or password is wrong!");  
					 request.getRequestDispatcher("/admin.jsp").forward(request, response);  
					 return;  
				}
			}else if(className.equals("1601")) {
				if (ad != null) {
				
					request.getSession().setAttribute("admin", ad);
					request.getRequestDispatcher("/admin_home1.jsp").forward(request, response);
				} else {
					 request.setAttribute("msg_admin", "the ID or password is wrong!");  
					 request.getRequestDispatcher("/admin.jsp").forward(request, response);  
					 return;  
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
