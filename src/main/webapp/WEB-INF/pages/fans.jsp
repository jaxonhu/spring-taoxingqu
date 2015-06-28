<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/style/fans.css"/> "/>
    <link rel="stylesheet" href="http://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css">
    <title></title>
</head>
<body>
<div class="header clearfix">
    <div class="logo">
        <img src="<c:url value="/resources/image/logo_home.png"/> " alt=""/>
    </div>
    <div class="search">
        <input class="search_input" type="text" value="" placeholder="我要搜索..."/>
        <a href="" class="icon_search">fff</a>
    </div>
    <div class="menu">
        <nav>
            <li style="font-size: 13px;">
                <a href="">
                    <i class="fa fa-home  fa-2x"></i>
                    <span class="header_span" style="color: #333;" >首页</span>
                </a>
            </li>
            <li style="font-size: 13px;">
                <a href="">
                    <i class="fa fa-user fa-2x"></i>
                    <span class="header_span" style="color: #333;">IAMyours1995</span>
                </a>
            </li>
        </nav>
    </div>
</div>

<div class="main_frame">
    <div class="main_left">

    </div>
    <div class="main_center">
        <div class="main_center_header" style="background-image: url('<c:url value="/resources/image/001.jpg"/> ')">
            <div class="face_header">
                <img  src="<c:url value="/resources/image/face2.jpg"/> " alt=""/>
            </div>
            <div class="face_name">
                <span>IAMyours1995</span>
            </div>
            <div class="follow">
                <a class="follow_btn" href="">关注</a>
            </div>
        </div>

        <nav class="menu_bar">
            <a href=""><li>我的微博</li></a>
            <a href=""><li style="border-left: 1px solid #c7cbda;">我的关注</li></a>
            <a href=""><li style="border-left: 1px solid #c7cbda;">我的粉丝</li></a>
        </nav>

        <div class="follow_container">
            <ul class="followers">
                <li>
                    <div class="follow_face">
                        <img src="<c:url value="/resources/image/face.jpg"/> " alt=""/>
                    </div>
                    <div class="follow_info">
                        <span class="follow_name">IAMyours1995</span>
                    </div>
                </li>
                <li>
                    <div class="follow_face">
                        <img src="<c:url value="/resources/image/face.jpg"/> " alt=""/>
                    </div>
                    <div class="follow_info">
                        <span class="follow_name">IAMyours1995</span>
                    </div>
                </li>
                <li>
                    <div class="follow_face">
                        <img src="<c:url value="/resources/image/face.jpg"/> " alt=""/>
                    </div>
                    <div class="follow_info">
                        <span class="follow_name">IAMyours1995</span>
                    </div>
                </li>
            </ul>
        </div>

    </div>
    <div class="main_right">

    </div>

</div>
</body>
</html>