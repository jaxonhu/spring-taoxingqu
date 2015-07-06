/**
 * Created by hujiaxuan on 2015/7/6.
 */
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

function addClass(obj, cls){
    if (!this.hasClass(obj, cls)) obj.className += " " + cls;
}

function hasClass(obj, cls) {
    return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
}
