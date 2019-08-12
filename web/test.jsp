<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/10
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student" method="post" id="search_form">
    <div class="searchBox png" id="searchBox">
        <input type="hidden" id="searchTxt" class="searchTxt"
               name="type" value="del">
        <a class="searchPic h-submitBtn png"
           id="h-submitBtn" href="#" onclick="document:search_form.submit();">
            删除
        </a>
    </div>
</form>
</body>
</html>
