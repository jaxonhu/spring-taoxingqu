/**
 * Created by hujiaxuan on 2015/7/6.
 */

function unclick(obj){

    return false;
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
            url:"/spring-taoxingqu/comment/show",
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
        url:"/spring-taoxingqu/weibo/publish",
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
        url:"/spring-taoxingqu/comment/publish",
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
        url:"/spring-taoxingqu/weibo/praise",
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
        url:"/spring-taoxingqu/weibo/praise",
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

