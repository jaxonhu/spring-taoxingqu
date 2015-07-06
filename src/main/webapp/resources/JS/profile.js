/**
 * Created by hujiaxuan on 2015/7/6.
 */
function check_cookie(user_name,res){
    var name = getCookie("user_name");
    if( res=="yes" ){
        update_follow_btn();
    }
    if(name == user_name){
        set_follow_btn_display();
    }else{
        $(".image_upload:eq(0)").remove();
    }
}

function update_follow_btn(){
    var follow = document.getElementsByClassName('follow')[0];
    follow.setAttribute("class","follow_already");
    var follow_btn = document.getElementsByClassName("follow_btn")[0];
    follow_btn.innerHTML="已经关注";
    follow_btn.setAttribute("onclick","javascript:void(0);");
}

function set_follow_btn_display(){
    var follow = document.getElementsByClassName('follow')[0];
    follow.style.display="none";
    var follow_btn = document.getElementsByClassName('follow_btn')[0];
    follow_btn.style.display="none";
}

function following(user_name){
    var user_name = document.getElementsByClassName("header_span")[1].innerHTML;
    var data = {
        user_name:user_name
    }
    $.ajax({
        type:"POST",
        url:"/spring-taoxingqu/following",
        data:data,
        success:function(data){
            if(data){
                alert("关注成功");
                update_follow_btn();
            }
        },
        error:function(){
            alert("ajax连接失败");
        }
    });
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
function CommentPublish(index,tao_id){
    var content = document.getElementsByClassName('content_comment')[index].value;
    var data ={
        content:content,
        tao_id:tao_id
    };
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
