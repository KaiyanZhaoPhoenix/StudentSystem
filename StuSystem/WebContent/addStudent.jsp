<%@page import="com.zky.bean.Student"%>
<%@page import="com.zky.service.impl.StudentServiceImpl"%>
<%@page import="com.zky.service.StudentService"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.zky.bean.Admin"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.zky.utils.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Administration Center</title>
<link href="css/style_admin.css" rel="stylesheet" type="text/css">
</head>

<script>
function windowHeight() {
	var de = document.documentElement;
	return self.innerHeight||(de && de.clientHeight)||document.body.clientHeight;
}
window.onload=window.onresize=function(){
	var wh=windowHeight();
	document.getElementById("xt-left").style.height = document.getElementById("xt-right").style.height = (wh-document.getElementById("xt-top").offsetHeight)+"px";
}
</script>
<body>

<!-- top -->
<div id="xt-top">
    <div class="xt-geren">
    	<%
	    	Admin admin = (Admin)request.getSession().getAttribute("admin");
			String admin_name = admin.getAdminname();
    	%>
        <div class="xt-exit"><span class="xt-span">Hello,<span class="xt-yanse"><%out.print(admin_name); %></span>!Welcome log in administration center.</span><a href="#" class="help">Help</a>
            <a href="#" class="exit">LOG OUT</a></div>
    </div>
</div>
<!-- left -->
<div class="xt-center">
<div id="xt-left">
    <div class="xt-logo"></div>
     <div class="xt-menu">
        <ul>
            <li><a href="admin_home.jsp?page=1" class="hover"><em class="one"></em>Basic Information</a></li>
            <li><a href="addStudent.jsp"><em class="two"></em>Add Student</a></li>
            <li><a href="findStudent.jsp"><em class="three"></em>Find Student</a></li>
        </ul>
        <div class="xt-menu-list"></div>
        <ul>
            <li><a href="AdminLogoutServlet" style="color: red;"><em class="two"></em>LOG OUT</a></li>
        </ul>
    </div>
</div>
<!-- right -->
<div id="xt-right">
    <div class="xt-bt">Basic information > Student Information > Add Student</div>
    <div class="xt-table">
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
       		<tr>
            <th>Student ID</th>
            <th>Student Year</th>
            <th>Student Class</th>
            <th>Student Name</th>
            <th>Student Study_year</th>
            <th>Student Phone_call</th>
            <th>Options</th>
            </tr>
          	<form action="AddServlet" id="add" name="add" method="post">
            <tr>
                <td><input style="width:100px" type="text" name="id" ></td>
              	<td><input style="width:60px" type="text" name="year"></td>
              	<td><input style="width:100px" type="text" name="class" ></td>
              	<td><input style="width:40px" type="text" name="name" ></td>
              	<td><input style="width:100px" type="text" name="studyyear" ></td>
              	<td><input style="width:100px" type="text" name="phonecall" ></td>
              	
                <td><a href="#" onclick="document.getElementById('add').submit()" class="blue-xt">Add</a></td>
            </tr>
         	</form>
         	<h3 style="color:red;">${msg_add}</h3>
        </table>
    </div>
</div>
</div>

</body>
</html>