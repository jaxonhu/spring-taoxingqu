<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/style/follow.css"/>"/>
    <link rel="stylesheet" href="http://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css">
    <link href="<c:url value="/resources/style/common.css"/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/resources/style/header.css"/>"/>
    <script  src="<c:url value="/resources/JS/common.js"/>"></script>
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
                    <span class="header_span" style="color: #333;">${user_name}</span>
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
                <span>${user_name}</span>
            </div>
            <div class="follow">
                <a class="follow_btn" href="">关注</a>
            </div>
        </div>

        <nav class="menu_bar">
            <a href="<%=request.getContextPath()%>/profile?page=1&tag=&user_id=${user_name}"><li>我的微博</li></a>
            <a href="<%=request.getContextPath()%>/follow?page=1&user_id=${user_name}"><li style="border-left: 1px solid #c7cbda;">我的关注</li></a>
            <a href="<%=request.getContextPath()%>/fans?page=1&user_id=${user_name}"><li style="border-left: 1px solid #c7cbda;">我的粉丝</li></a>
        </nav>

        <div class="follow_container">
            <ul class="followers">
                <c:forEach items="${FollowList}" var="user" varStatus="vs">
                <li>
                    <div class="follow_face">
                        <img src="${user.face_url}"alt=""/>
                    </div>
                    <div class="follow_info">
                        <span class="follow_name">${user.user_name}</span>
                    </div>
                </li>
                </c:forEach>
            </ul>
        </div>
        <div class="main_footer">
            <a href="" class="prev_footer"   >上一页</a>
            <!--<span class="center_footer"></span>-->
            <a href="" class="next_footer"  >下一页</a>
        </div>

    </div>
    <div class="main_right">

    </div>
</div>

<script>
    window.onload = init(${index},${isNextPage});
    function init(index,isNextPage){
        var user_name = getCookie("user_name");
        var prev = document.getElementsByClassName("prev_footer");
        var next = document.getElementsByClassName("next_footer");
        if(index == 1){
            addClass(prev[0],"unclick");
            prev[0].href = 'javascript:void(0);';
            if(!isNextPage){
                addClass(next[0],"unclick");
                next[0].href = 'javascript:void(0);';
            }else{
                next[0].href = "<%=request.getContextPath()%>/follow?user_id=${user_name}page="+(index+1);
            }
        }else{
            if(!isNextPage){
                addClass(next[0],"unclick");
                next[0].href = 'javascript:void(0);';
                prev[0].href = "<%=request.getContextPath()%>/follow?user_id=${user_name}page="+(index-1);
            }else{
                prev[0].href = "<%=request.getContextPath()%>/follow?user_id=${user_name}page="+(index-1);
                next[0].href = "<%=request.getContextPath()%>/follow?user_id=${user_name}page="+(index+1);
            }
        }
    }
</script>
</body>
</html>