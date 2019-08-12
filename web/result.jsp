<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>查询结果</title>
    <script>

        function ad(jp) {
            document:jp.submit();
        }

        function de(jp) {
            document.getElementById("jump").value = "de";
            document:jp.submit();
        }

        function se(jp) {
            document.getElementById("jump").value = "se";
            document:jp.submit();
        }
    </script>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th colspan="2">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="s" varStatus="v">
        <form    action="/student" method="post">
            <input id="${s.stuName}${v.count}" type="hidden" name="type" value="del">
            <input type="hidden" name="stuNo" value="${s.stuNo}"/>
            <input type="hidden" name="stuName" value="${s.stuName}"/>
            <input type="hidden" name="stuSex" value="${s.stuSex}"/>
            <input type="hidden" name="stuAge" value="${s.stuAge}"/>
            <tr>
                <th>${s.stuNo}</th>
                <th>${s.stuName}</th>
                <th>${s.stuSex}</th>
                <th>${s.stuAge}</th>
                <th>
                   <a onclick="document.getElementById('${s.stuName}${v.count}').value='update'">
                       <button type="submit" style="background: none;border: 0;text-decoration: underline;
                        font-weight: 900;font-size: 16px;">修改</button>
                   </a>
                </th>
                <th>
                    <a>
                    <button type="submit" style="background: none;border: 0 ;
                    text-decoration: underline; font-weight: 900;font-size: 16px;" >删除</button>
                    </a>
                </th>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>
<form id="jp" action="/student" method="post">
    <input type="hidden" id="jump" name="jump" value="ad">
    <button><a href="#" onclick="ad(jp);">新增</a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button><a href="#" onclick="de(jp);">删除</a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button><a href="#" onclick="se(jp);">查找</a></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</form>
</body>
</html>
