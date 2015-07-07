<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/home.css"/> "/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.css"/> "/>
    <link rel="stylesheet" href="<c:url value="/resources/style/listmenu.css"/>"/>
    <link rel="stylesheet" href="http://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css">
    <link href="<c:url value="/resources/style/common.css"/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/resources/style/header.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/style/weibo.css"/>"/>
    <script src="<c:url value="/resources/JS/jquery-1.6.1.min.js"/>"></script>
    <script  src="<c:url value="/resources/JS/common.js"/>"></script>
    <script  src="<c:url value="/resources/JS/ajaxfileupload.js"/>"></script>
    <script  src="<c:url value="/resources/JS/face_upload.js"/>"></script>
    <script  src="<c:url value="/resources/JS/home.js"/>"></script>
    <title></title>
</head>
<body>
    <div class="header clearfix">
        <div class="logo">
            <%--<img src="<c:url value="/resources/image/logo_home.png"/>" alt=""/>--%>
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
                        <span class="header_span" id="user_id" style="color: #333;">${user_name}</span>
                    </a>
                </li>

            </nav>
        </div>
    </div>
    <div class="main_frame clearfix">
        <div class="main_left">
            <nav class="left_tag">
                <li><a href="<%=request.getContextPath()%>/homes?tag=互联网&page=1">互联网</a></li>
                <li><a href="<%=request.getContextPath()%>/homes?tag=经济&page=1">经济</a></li>
                <li><a href="<%=request.getContextPath()%>/homes?tag=篮球&page=1">篮球</a></li>
                <li><a href="<%=request.getContextPath()%>/homes?tag=时政&page=1">时政</a></li>
                <li><a href="<%=request.getContextPath()%>/homes?tag=足球&page=1">足球</a></li>
                <li><a href="<%=request.getContextPath()%>/homes?tag=情感&page=1">情感</a></li>
                <li><a href="<%=request.getContextPath()%>/homes?tag=大学生活&page=1">大学生活</a></li>
                <li><a href="<%=request.getContextPath()%>/homes?tag=历史&page=1">历史</a></li>
            </nav>
        </div>
        <div class="main_center">
            <div class="send_msg">
                <div class="input">
                    <textarea name="input" class="input_msg" id=""></textarea>
                </div>
                <div class="send_bar clearfix">
                    <nav class="send_icon">
                        <li>
                            <a href="javascript:void(0)" style="text-decoration: none; color: #0f1012;">
                                <i class="fa fa-picture-o"></i>
                                <span class="send_img" style="font-size: 14px;">图片</span>
                                <%--<input type="file" id="file" name="file"/>--%>
                                <%--<input value="upload" type="button" id="upload" onclick="ImageUpload();">上传</input>--%>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);"  onclick="load_tags();" style="text-decoration: none; color: #0f1012;">
                                <i class="fa fa-tags"></i>
                                <span class="send_img" style="font-size: 14px;">分类</span>
                            </a>
                        </li>
                    </nav>

                    <div class="tags clearfix" id="tag">
                        <a href="javascript:void(0);" onclick="click_tags(this);">互联网</a>
                        <a href="javascript:void(0);" onclick="click_tags(this);">经济</a>
                        <a href="javascript:void(0);" onclick="click_tags(this);">篮球</a>
                        <a href="javascript:void(0);" onclick="click_tags(this);">时政</a>
                        <a href="javascript:void(0);" onclick="click_tags(this);">足球</a>
                        <a href="javascript:void(0);" onclick="click_tags(this);">情感</a>
                        <a href="javascript:void(0);" onclick="click_tags(this);">大学生活</a>
                        <a href="javascript:void(0);" onclick="click_tags(this);">历史</a>
                    </div>

                    <a href="javascript:void(0)" class="send_button" onclick="WeiboPublish(0); return false;" >发布</a>
                </div>
            </div>
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
                            <a href="javascript:void(0)" onclick="GivePraise(${vs.index},'${list.weibo.tao_id}');return false;"><li  style="font-size:17px;"><i class="fa fa-thumbs-o-up"  ><span class="thumb_on" style="font-size: 12px">${list.weibo.thumb_on}</span></i>
                            </li></a>
                            <a href="javascript:void(0)" onclick="GiveDown(${vs.index},'${list.weibo.tao_id}');return false;" ><li style="font-size:17px;"><i class="fa fa-thumbs-o-down"><span class="thumb_down" style="font-size: 12px">11</span></i>
                            </li></a>
                            <a href="javascript:void(0)" onclick="load_comments(${vs.index},'${list.weibo.tao_id}');return false;"><li><span style="color: #808080;font-size: 12px;">评论</span></li></a>
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
            <div class="person_info">
                <div class="right_face">
                    <a href="<%=request.getContextPath()%>/profile?page=1&tag=&user_id=${user_name}"><img src="${face_url}" alt=""/></a>

                </div>
                <div class="right_name">
                    <a href="<%=request.getContextPath()%>/profile?page=1&tag=&user_id=${user_name}">${user_name}</a>
                </div>
                <nav class="person_menu">
                    <li><a href="<%=request.getContextPath()%>/follow?page=1&user_id=${user_name}" style="text-decoration: none;"><strong>${follow_num}</strong>
                        <span>关注</span></a>
                        </li>
                    <li><a href="<%=request.getContextPath()%>/fans?page=1&user_id=${user_name}"  style="text-decoration: none;"><strong>${fans_num}</strong>
                        <span>粉丝</span></a>
                    </li>
                    <li><a href="<%=request.getContextPath()%>/profile?page=1&tag=&user_id=${user_name}"  style="text-decoration: none;"><strong>${weibo_num}</strong>
                        <span>微博</span></a>
                    </li>
                </nav>
            </div>
        </div>

    </div>
    <script>
        window.onload = init(${index},${isNextPage});
        function init(index,isNextPage){
            var prev = document.getElementsByClassName("prev_footer");
            var next = document.getElementsByClassName("next_footer");
            setCookie("user_name","${user_name}",365);
            if(index == 1){
                addClass(prev[0],"unclick");
                prev[0].href = 'javascript:void(0);';
                if(!isNextPage){
                    addClass(next[0],"unclick");
                    next[0].href = 'javascript:void(0);';
                }else{
                    next[0].href = "<%=request.getContextPath()%>/homes?tag=${tag}&page="+(index+1);
                }
            }else{
                if(!isNextPage){
                    addClass(next[0],"unclick");
                    next[0].href = 'javascript:void(0);';
                    prev[0].href = "<%=request.getContextPath()%>/homes?tag=${tag}&page="+(index-1);
                }else{
                    prev[0].href = "<%=request.getContextPath()%>/homes?tag=${tag}&page="+(index-1);
                    next[0].href = "<%=request.getContextPath()%>/homes?tag=${tag}&page="+(index+1);
                }
            }


        }
    </script>
</body>
</html>