<%@ page import="entity.Student" %>
<%@ page import="utils.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/10
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String stuNo = request.getParameter("stuNo");
    String stuName = request.getParameter("stuName");
    String stuSex = request.getParameter("stuSex");
    String stuAge = request.getParameter("stuAge");

    request.setAttribute("stuNo",stuNo);
    request.setAttribute("stuName",stuName);
    request.setAttribute("stuSex",stuSex);
    request.setAttribute("stuAge",stuAge);
%>
<html>
<head>
    <title>修改</title>
</head>
<body>
<%--<script>--%>
<%--    function c(upd){--%>
<%--        // if(!confirm('确定更改数据?')) {--%>
<%--        //     history.back();--%>
<%--        //     return false;--%>
<%--        // }else {--%>
<%--            document.forms[upd].submit();--%>
<%--        // }--%>
<%--    }--%>
<%--</script>--%>



<form  id="upd" action="/student" method="post">
    <input type="hidden" name="type" value="update"/>
    <input type="hidden" name="update2" value="update2"/>
    <input type="hidden" name="oldNo" value="${stuNo}">
    <input type="hidden" name="oldName" value="${stuName}">
    <input type="hidden" name="oldSex" value="${stuSex}">
    <input type="hidden" name="oldAge" value="${stuAge}">
    请输入需要修改的数据：<br/>
    学号：<input type="text" name="newNo" value="${stuNo}" ><br/>
    姓名：<input type="text" name="newName" value="${stuName}"/><br/>
    性别：<input type="text" name="nwSex"  value="${stuSex}" /><br/>
    年龄：<input type="text" name="newAge"  value="${stuAge}" /><br/>
    <button onclick="c(upd)">提交</button>
    <input type="button" value="返回" onclick="history.back()"/>
</form>
</body>
</html>
