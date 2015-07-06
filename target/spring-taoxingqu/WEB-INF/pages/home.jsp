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
    <script src="<c:url value="/resources/JS/jquery-1.6.1.min.js"/>"></script>
    <script  src="<c:url value="/resources/JS/ajaxfileupload.js"/>"></script>
    <script  src="<c:url value="/resources/JS/face_upload.js"/>"></script>
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
        function addEvent(eventTarget,eventType,eventHandler){
            if(eventTarget.addEventListener){
                eventTarget.addEventListener(eventType,eventHandler,false);
            }else{
                if(eventTarget.attachEvent){
                    eventType="on"+eventType;
                    eventTarget.attachEvent(eventType,eventHandler);
                }else{
                    eventTarget["on"+eventType]=eventHandler;
                }
            }
        }

        function setCookie(name,value,expirdays){
            var exdate = new Date();
            exdate.setDate(exdate.getDate()+expirdays);
            document.cookie=name+ "=" +escape(value)+
            ((expirdays==null) ? "" : ";expires="+exdate.toGMTString());
        }
        function getCookie(c_name)
        {
            if (document.cookie.length>0)
            {
                c_start=document.cookie.indexOf(c_name + "=")
                if (c_start!=-1)
                {
                    c_start=c_start + c_name.length+1
                    c_end=document.cookie.indexOf(";",c_start)
                    if (c_end==-1) c_end=document.cookie.length
                    return unescape(document.cookie.substring(c_start,c_end))
                }
            }
            return ""
        }
        function unclick(obj){

            return false;
        }

        function addClass(obj, cls){
            if (!this.hasClass(obj, cls)) obj.className += " " + cls;
        }

        function hasClass(obj, cls) {
            return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
        }

        function load_comments(index,weibo_id){
            var list = document.getElementsByClassName("comments");
            var content = document.getElementById("content_comment");
            var user_id = getCookie("user_name");
            var data = {
                user_id:user_id,
                tao_id: weibo_id,
                page:1
            };
            if(list[index].style.display == "none"){
                $.ajax({
                    type:"POST",
                    url:"<%=request.getContextPath()%>/comment/show",
                    data:data,
                    page:1,
                    dataType:"json",
                    success:function(data){
                        if(data){
                            $.each(data,function(index1){
                                var content =
                                "<div class='comment_item clearfix'>"+
                                "<div class='comment_face'>"+
                                "<img src='"+data[index1].user_face_url+"' height='30' width='30'/>"+
                                "</div>"+
                                "<div class='comment_content'>"+
                                "<span>"+data[index1].user_id+"</span>"+
                                 "   ："+data[index1].comment+
                                "</div>"+
                                "</div>"

                                $(".comment_list:eq("+index+")").append(content);
                            });

                        }
                        show_comments(index);
                    },
                    error:function(){
                        alert("ajax连接失败");
                    }
                });
            }else{
                $(".comment_list:eq("+index+")").empty();
                list[index].style.display = "none";
            }
        }
        function show_comments(index){
            var commentlist = document.getElementsByClassName("comments");
            if (commentlist[index].style.display == "none") {
                commentlist[index].style.display = "block";
            } else {
                commentlist[index].style.display = "none";
            }
        }
        function load_tags(){
            var ob = document.getElementById('tag');
            var demo = window.getComputedStyle(ob,null);
            if(demo.left == "270px"){
                ob.style.left = "-999px"
                ob.style.opacity = "0";
            }else{
                ob.style.left = "270px";
                ob.style.opacity = "1";
            }
        }
        function click_tags(Object){
            var tag_name =Object.innerHTML;
            var tag = document.getElementById("tag");
            var a = document.getElementsByClassName("send_bar")[0];
            var span_tag = document.getElementById("weibo_tag");
            if(span_tag){
                span_tag.innerHTML = tag_name;
            }else{
                span_tag = document.createElement("span");
                a.insertBefore(span_tag,tag);
                span_tag.id = "weibo_tag";
                span_tag.innerHTML = tag_name;
            }
        }

        function WeiboPublish(index){
            var content = document.getElementsByClassName("input_msg");
            var user_id = document.getElementById("user_id").innerHTML;
            var interest_id = document.getElementById("weibo_tag").innerHTML;
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

        function CommentPublish(index,tao_id){
            var content = document.getElementsByClassName('content_comment')[index].value;
            var data ={
                content:content,
                tao_id:tao_id
            };
            alert(content);
            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/comment/publish",
                data:data,
                success:function(data){
                    if(data){
                        alert("评论成功");
                    }
                },
                error:function(){
                    alert("ajax连接失败");
                }
            });
        }

        function GivePraise(index,tao_id){

            var data = {
                tao_id:tao_id
            }
            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/weibo/praise",
                data:data,
                success:function(data){
                    if(data){
                        alert("点赞成功哟！");
                    }
                    var num = $(".thumb_on:eq("+index+")").html();
                    alert($(".thumb_on:eq("+index+")").html());
                    num = parseInt(num,10);
                    num+=1;
                    $(".thumb_on:eq("+index+")").html(num);
                    $(".thumb_on:eq("+index+")").parent().css('color','#ffa00a');
                    $(".thumb_on:eq("+index+")").css('color','#ffa00a');
                    $(".handler_msg:eq("+index+")").find('a:eq(0)').attr('onclick','return false;');
                },
                error:function(){
                    alert("服务器君便当了~");
                }
            });
        }
        function GiveDown(index,tao_id){

            var data = {
                tao_id:tao_id
            }
            $.ajax({
                type:"POST",
                url:"<%=request.getContextPath()%>/weibo/praise",
                data:data,
                success:function(data){
                    if(data){
                        alert("点赞成功哟！");
                    }
                    var num = $(".thumb_down:eq("+index+")").html();
                    alert($(".thumb_down:eq("+index+")").html());
                    num = parseInt(num,10);
                    num+=1;
                    $(".thumb_down:eq("+index+")").html(num);
                    $(".thumb_down:eq("+index+")").parent().css('color','#ffa00a');
                    alert($(".thumb_down:eq("+index+")").parent().html());
                    $(".thumb_down:eq("+index+")").css('color','#ffa00a');
                    $(".handler_msg:eq("+index+")").find('a:eq(1)').attr('onclick','return false;');
                },
                error:function(){
                    alert("服务器君便当了~");
                }
            });
        }
    </script>
</body>
</html>