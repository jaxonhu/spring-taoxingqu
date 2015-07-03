/**
 * Created by hujiaxuan on 2015/7/3.
 */
function ImageUpload(){
    $.ajaxFileUpload({
        url : '/spring-taoxingqu/upload.do', //用于文件上传的服务器端请求地址
        secureuri : false, //一般设置为false
        fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
        type : 'post',
        dataType : 'json', //返回值类型 一般设置为json
        success : function(data, status) //服务器成功响应处理函数
        {
            alert("success");
            //$("#picList").datagrid('reload');
            //$('#uploadPicWindow').window('close');
            // alert(data.msg);
        },
        error : function(data, status, e)//服务器响应失败处理函数
        {
            alert("error");
            //$("#picList").datagrid('reload');
            //$('#uploadPicWindow').window('close');
            // alert(data.msg);
        }
    });
}
