<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24 0024
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
上传成功
<c:if test="${student.head !=null }">
    <img id="images" alt="" src="/${student.head }">
</c:if>
</body>
</html>
