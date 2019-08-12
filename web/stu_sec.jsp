<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找</title>
</head>
<%--<script type='text/javascript'></script>--%>
<%--<script type="text/javascript"> function clearbutton() { if (!confirm("确定要重写吗？")) return false; } </script>--%>

<body>

<form action="/student" method="post"  >
    <input type="hidden" name="type" value="search" >
    <input type="hidden" name="all" value="searchAll" >
    学号:<input type="text" name="stuNo"/><br/>
    姓名:<input type="text" name="stuName"/><br/>
    性别;
    <input type="radio" name="stuSex" value="男"/>男
    <input type="radio" name="stuSex" value="女"/>女<br/>
    年龄:<input type="text" name="stuAge"/><br/>
    <input type="submit" value="查询"/>&nbsp;
    <input type="button" value="返回" onclick="history.back()"/>
</form>

</body>
</html>
