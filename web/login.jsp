<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/9
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<thead><th>欢迎登录</th></thead>
<form action="/login" method="post">
    <div>
        账号：<input type="text" name="username" />
    </div>
    <div>
        密码：<input type="text" name="password" />
    </div>
    <div>
        <input type="submit" value="登录" />
    </div>
</form>
</body>
</html>
