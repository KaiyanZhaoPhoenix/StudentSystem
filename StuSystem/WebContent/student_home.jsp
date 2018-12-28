<%@ page import="com.zky.bean.Student" import="java.util.Date" import="com.zky.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" http-equiv="Content-Type" content="width=device-width, initial-scale=1" >
<title>Student Home</title>
<link rel="stylesheet" href="css/style.css">
<link href="./css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="./css/style_StudentHome.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="./js/jquery.min.js"></script>
<link href='http://fonts.useso.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
</head>
<body>

<div class="cotn_principal">
  <div class="cont_centrar">  
   		<div class="header">
		<div class="header-banner">			
			<div class="container">
				<div class="top-menu">
					<form action="LogoutServlet" name="logout" method="get">
						<button class="btn_sign_up">Log out</button>
					</form>
				</div>
				<div class="header-banner-info text-center">
					<a href="#"><img src="./img/logo.png" alt="" /></a>
					<h3>HELLO</h3>
					<h2><span><%
					Student student = (Student)request.getSession().getAttribute("student");
					String name = student.getName();
					out.print(name);
					%></span> </h2>
					<p>A student in HZAU</p> 
					    
<!-- 					<span class="line"></span>		 -->
<!-- 					<label></label> -->
					<div class="container">
					<ul class="details">
						<li>ID     :     <a><%
								String id = student.getId();
								out.print(id);%></a></li>
						<li>Year     :     <a><%
								String year = student.getYear();
								out.print(year);%></a></li>
						<br/><br/><br/>
						<li>Class     :     <a><%
								String classs = student.getClasss();
								out.print(classs);%></a></li>
						<li>Name     :     <a><%
								String p = student.getName();
								out.print(p);%></a></li>
						<br/><br/><br/>
						<li>Study Year     :     <a><%
								int a = student.getStudyyear();
								out.print(a);%></a></li>
						<li>Telephone     :     <a><%
								String b = student.getPhonecall();
								out.print(b);%></a></li>		
					</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
  </div>
</div>   
</body>
</html>