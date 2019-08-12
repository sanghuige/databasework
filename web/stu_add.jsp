<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加</title>
</head>
<body>
<form action="/student" method="post">
    <input type="hidden" name="type" value="add" />
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="stuName" /></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <select name="stuSex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="stuAge" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存">
                <input type="button" value="返回" onclick="history.back()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
