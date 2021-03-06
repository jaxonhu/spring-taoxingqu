<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/style/profile.css"/> "/>
    <link rel="stylesheet" href="http://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css">
    <link href="<c:url value="/resources/style/common.css"/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/resources/style/header.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/style/weibo.css"/>"/>
    <script src="<c:url value="/resources/JS/jquery-1.6.1.min.js"/>"></script>
    <script  src="<c:url value="/resources/JS/ajaxfileupload.js"/>"></script>
    <script  src="<c:url value="/resources/JS/profile.js"/>"></script>
    <script  src="<c:url value="/resources/JS/common.js"/>"></script>
    <%--<script src="http://code.jquery.com/jquery-1.9.1.js"></script>--%>
    <%--<script src="http://malsup.github.com/jquery.form.js"></script>--%>
    <script  src="<c:url value="/resources/JS/face_upload.js"/>"></script>
    <title>${user_name}的个人主页</title>
</head>
<body>
<div class="header clearfix">
    <div class="logo">
        <%--<img src="<c:url value="/resources/image/logo_home.png"/> " alt=""/>--%>
    </div>
    <div class="search">
        <input class="search_input" type="text" value="" placeholder="我要搜索..."/>
        <a href="" class="icon_search">fff</a>
    </div>
    <div class="menu">
        <nav>
            <li style="font-size: 13px;">
                <a href="<%=request.getContextPath()%>/homes?page=1&tag=">
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
                <img  src="${face_url}" alt=""/>
            </div>
            <div class="face_name">
                <span>${user_name}</span>
            </div>
            <div class="follow">
                <a class="follow_btn" onclick="following('${user_name}');" href="javascript:void(0);">关注</a>
            </div>
            <div class="image_upload">
                <div id="file_btn">
                    <input type="file" id="file" name="file"/>
                </div>
                <div id="upload_btn">
                    <input value="上传" type="button" id="upload" onclick="ImageUpload();">
                </div>
            </div>
        </div>

        <nav class="menu_bar">
            <a href="<%=request.getContextPath()%>/profile?page=1&tag=&user_id=${user_name}"><li>我的微博</li></a>
            <a href="<%=request.getContextPath()%>/follow?page=1&user_id=${user_name}"><li style="border-left: 1px solid #c7cbda;">我的关注</li></a>
            <a href="<%=request.getContextPath()%>/fans?page=1&user_id=${user_name}"><li style="border-left: 1px solid #c7cbda;">我的粉丝</li></a>
        </nav>

        <c:forEach items="${UnionList}" var="list" varStatus="vs">
            <div class="item_msg" id="${list.weibo.tao_id}">
                <div class="detail_msg">
                    <div class="face">
                        <a href="<%=request.getContextPath()%>/profile?page=1&tag=&user_id=${list.weibo.user_id}">
                            <img src="${list.user.face_url}" style="height: 50px;width: 50px;" alt=""/>
                        </a>
                    </div>

                    <div class="detail">
                        <div class="detail_name"><a href="<%=request.getContextPath()%>/profile?page=1&tag=&user_id=${list.weibo.user_id}">${list.weibo.user_id}</a></div>
                        <div class="detail_content">${list.weibo.wb_content}</div>
                    </div>
                </div>

                <div class="handler_msg" id="${list.weibo.tao_id}">
                    <nav>
                        <a href="" onclick="GivePraise(${vs.index},'${list.weibo.tao_id}');return false;"><li style="font-size:17px;"><i class="fa fa-thumbs-o-up" ><span style="font-size: 12px">${list.weibo.thumb_on}</span></i>
                        </li></a>
                        <a href="" onclick="return false;" ><li style="font-size:17px;"><i class="fa fa-thumbs-o-down"><span style="font-size: 12px">11</span></i>
                        </li></a>
                        <a href="" onclick="load_comments(${vs.index},'${list.weibo.tao_id}');return false;"><li><span style="color: #808080;font-size: 12px;">评论</span></li></a>
                    </nav>
                </div>

                <div class="comments" style="display: none;">
                    <div class="give_comment clearfix">
                        <div class="comment_input">
                            <textarea name="comment" class="content_comment" id="content_comment" cols="30" rows="10"></textarea>
                        </div>
                        <a href="javascript:void(0)" onclick="CommentPublish(${vs.index},'${list.weibo.tao_id}');" class="send_comment">发送</a>
                    </div>
                    <div class="comment_list">
                        <!--这里加载评论-->
                    </div>
                </div>
            </div>
        </c:forEach>
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
        var prev = document.getElementsByClassName("prev_footer");
        var next = document.getElementsByClassName("next_footer");
        check_cookie("${user_name}","${focus}");
        if(index == 1){
            addClass(prev[0],"unclick");
            prev[0].href = 'javascript:void(0);';
            if(!isNextPage){
                addClass(next[0],"unclick");
                next[0].href = 'javascript:void(0);';
            }else{
                next[0].href = "<%=request.getContextPath()%>/profile?tag=&page="+(index+1);
            }
        }else{
            if(!isNextPage){
                addClass(next[0],"unclick");
                next[0].href = 'javascript:void(0);';
                prev[0].href = "<%=request.getContextPath()%>/profile?tag=&page="+(index-1);
            }else{
                prev[0].href = "<%=request.getContextPath()%>/profile?tag=&page="+(index-1);
                next[0].href = "<%=request.getContextPath()%>/profile?tag=&page="+(index+1);
            }
        }
    }
</script>

</body>
</html>