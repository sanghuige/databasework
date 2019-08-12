<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>数据库记录</title>

</head>
<body>
<form action="studentServlet" method="post" style="align-content: center">
    <input type="hidden" name="opr" value="add" />
    <table border="1">
        <thead>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="s" varStatus="v">
            <tr>
                <th>${s.stuNo}</th>
                <th>${s.stuName}</th>
                <th>${s.stuSex}</th>
                <th><a href="#">删除</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
