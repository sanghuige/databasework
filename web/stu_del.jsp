<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/9
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>删除</title>
</head>
<body>
<form action="/student" method="post">
    <input type="hidden" name="type" value="del"/>
    请输入需要删除的数据：<br/>
    学号：<input type="text" name="stuNo" ><br/>
    姓名：<input type="text" name="stuName" /><br/>
    性别：<input type="text" name="stuSex" /><br/>
    年龄：<input type="text" name="stuAge" /><br/>
    <input type="submit" value="删除"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="返回" onclick="history.back()"/>
</form>
</body>
</html>
