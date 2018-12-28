<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>Admin login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />

</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>Welcome to the System</h3>
					<form action="AdminLoginServlet" id="admin_login" name="admin_login" method="post">
						<div class="input_outer">
							<span class="u_user"></span>
							<input name="adminname" class="text" style="color: #FFFFFF !important" type="text" placeholder="Please enter the account">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span>
							<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="Please enter the password">
						</div>
						<div class="radio">
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios1" value="1601" checked>计科1601
							</label>
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios2" value="1602">计科1602
							</label>
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios3" value="1603">计科1603
							</label>
							<label>
								<input type="radio" name="optionsRadios" id="optionsRadios4" value="1604">计科1604
							</label>
						</div>
						<div class="mb2"><a class="act-but submit" href="#" onclick="document.getElementById('admin_login').submit()" style="color: #FFFFFF">LOGIN</a></div>
						 
						<div class="mb2"><a class="act-but submit" href="index.jsp"  style="color: #2F4F4F">UserLoginPage</a></div> 
						 <h3 style="color:red;">${msg_admin}</h3>
					</form>
				</div>
			</div>
		</div>
	</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
	</body>
</body>
</html>