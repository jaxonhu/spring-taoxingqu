<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style/home.css"/> "/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome.css"/> "/>
    <link rel="stylesheet" href="http://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css">
    <script src="<c:url value="/resources/JS/jquery-1.11.3.js"/>"></script>
    <title></title>
</head>
<body>
    <div class="header clearfix">
        <div class="logo">
            <img src="<c:url value="/resources/image/logo_home.png"/>" alt=""/>
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
                        <span class="header_span" id="user_id" style="color: #333;">IAMyours1995</span>
                    </a>
                </li>
            </nav>
        </div>
    </div>
    <div class="main_frame clearfix">
        <div class="main_left">

        </div>
        <div class="main_center">
            <div class="send_msg">
                <div class="input">
                    <textarea name="input" class="input_msg" id=""></textarea>
                </div>
                <div class="send_bar clearfix">
                    <nav class="send_icon">
                        <li>
                            <a href="" style="text-decoration: none; color: #0f1012;">
                                <i class="fa fa-picture-o"></i>
                                <span class="send_img" style="font-size: 14px;">图片</span>
                            </a>
                        </li>
                    </nav>
                    <a href="" class="send_button" onclick="WeiboPublish(0); return false;" >发布</a>
                </div>
            </div>
            <c:forEach items="${weiboList}" var="weibo" varStatus="vs">
                <div class="item_msg">
                    <div class="detail_msg">
                        <div class="face">
                            <a href="">
                                <img src="<c:url value="/resources/image/face.jpg"/> " alt=""/>
                            </a>
                        </div>

                        <div class="detail">
                            <div class="detail_name"><a href="">${weibo.user_id}</a></div>
                            <div class="detail_content">${weibo.wb_content}</div>
                        </div>
                    </div>

                    <div class="handler_msg">
                        <nav>
                            <a href="" onclick="return false;"><li style="font-size:17px;"><i class="fa fa-thumbs-o-up" ><span style="font-size: 12px">${weibo.thumb_on}</span></i>
                            </li></a>
                            <a href="" onclick="return false;" ><li style="font-size:17px;"><i class="fa fa-thumbs-o-down"><span style="font-size: 12px">11</span></i>
                            </li></a>
                            <a href="" onclick="load_comments(${vs.index});return false;"><li><span style="color: #808080;font-size: 12px;">评论</span></li></a>
                        </nav>
                    </div>

                    <div class="comments" style="display: none;">
                        <div class="give_comment clearfix">
                            <div class="comment_input">
                                <textarea name="comment"  cols="30" rows="10"></textarea>
                            </div>
                            <a href="" class="send_comment">发送</a>
                        </div>
                        <div class="comment_list">
                            <!--这里加载评论-->
                            <div class="comment_item clearfix">
                                <div class="comment_face">
                                    <img src="<c:url value="/resources/image/face.jpg"/> " height="30" width="30" alt=""/>
                                </div>
                                <div class="comment_content">
                                    <span>IAMyours1995</span>
                                    ：ee
                                </div>
                            </div>
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
                    <a href=""><img src="<c:url value="/resources/image/face2.jpg"/> " alt=""/></a>

                </div>
                <div class="right_name">
                    <a href="">IAMyours1995</a>
                </div>
                <nav class="person_menu">
                    <li><a href="" style="text-decoration: none;"><strong>44</strong>
                        <span>关注</span></a>
                        </li>
                    <li><a href=""  style="text-decoration: none;"><strong>44</strong>
                        <span>粉丝</span></a>
                    </li>
                    <li><a href=""  style="text-decoration: none;"><strong>44</strong>
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
            if(index == 1){
                addClass(prev[0],"unclick");
                prev[0].href = 'javascript:void(0);';
                if(!isNextPage){
                    addClass(next[0],"unclick");
                    next[0].href = 'javascript:void(0);';
                }else{
                    next[0].href = "<%=request.getContextPath()%>/homes?page="+(index+1);
                }
            }else{
                if(!isNextPage){
                    addClass(next[0],"unclick");
                    next[0].href = 'javascript:void(0);';
                    prev[0].href = "<%=request.getContextPath()%>/homes?page="+(index-1);
                }else{
                    prev[0].href = "<%=request.getContextPath()%>/homes?page="+(index-1);
                    next[0].href = "<%=request.getContextPath()%>/homes?page="+(index+1);
                }
            }


        }
        function addEvent(eventTarget,eventType,eventHandler){
            if(eventTarget.addEventListener){
                eventTarget.addEventListener(eventType,eventHandler,false);
                alert("hello");
            }else{
                alert("world");
                if(eventTarget.attachEvent){
                    eventType="on"+eventType;
                    eventTarget.attachEvent(eventType,eventHandler);
                }else{
                    eventTarget["on"+eventType]=eventHandler;
                }
            }
        }

        function unclick(obj){

            return false;
        }

        function addClass(obj, cls) {
            if (!this.hasClass(obj, cls)) obj.className += " " + cls;
        }

        function hasClass(obj, cls) {
            return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
        }

        function load_comments(index) {
//            var commentlist = doucument.getElementById(index);
            var commentlist = document.getElementsByClassName("comments");
            if (commentlist[index].style.display == "none") {
                commentlist[index].style.display = "block";
            } else {
                commentlist[index].style.display = "none";
            }
        }
        function WeiboPublish(index){
            var content = document.getElementsByClassName("input_msg");
            var user_id = document.getElementById("user_id").innerHTML;
            var interest_id = "basketball";
            var weibo = content[index].value;
            var pic_url = "C:/";
            var thumb_on = 0;
            var data = {
                content:weibo,
                pic_url:pic_url,
                thumb_on:thumb_on,
                user_id:user_id,
                interest_id:interest_id
            };
            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/weibo/publish",
                data:data,
                success:function(data){
                  if(data){
                      alert("微博发布成功");
                  }
                },
                error:function(){
                    alert("ajax连接失败");
                }
            });
        }
    </script>
</body>
</html>