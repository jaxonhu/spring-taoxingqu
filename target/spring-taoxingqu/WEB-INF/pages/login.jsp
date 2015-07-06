<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link href="<c:url value="/resources/style/login.css"/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/style/common.css"/>" rel="stylesheet" type="text/css" />
</head>
<body class="B_login">
	<div class="main">
		<div class="main-header">
		<div class="logo">
			<img src="<c:url value="/resources/image/logo.png"/>"  alt=""/>
		</div>
		</div>
		<div class="main-container clearfix">
			<div class="leftbox">
				<img src="<c:url value="/resources/image/550x270_img52d772680d223.png"/> " style="position: relative; left: 10px;"alt="xx"/>
			</div>
			<div class="loginbox">
				<div class="login_form">
					<form action="/spring-taoxingqu/login.do" class="myform" method="post">
						<input type="text" class="account" name="user_name" placeholder="请输入用户名"/>
						<input type="password" class="pwd" name="password" placeholder="请输入登录密码"/>
						<button type="submit" class="click_login">登录</button>
					</form>
					<span class="login_span">还没账号？赶快注册！</span>
					<a class="register" href="/spring-taoxingqu/register">
						<span class="span_register">注册</span>
					</a>
				</div>

			</div>
		</div>
	</div>
	<script>
		window.onload=init(${result});
		function init(message){
			if(message == "error"){
				alert("注册失败");
			}
		}
	</script>
</body>
</html>