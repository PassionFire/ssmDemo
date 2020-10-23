<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23 0023
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #search{
            text-align: center;
        }
        #search span{
            font-size: 25px;
        }
        #search select{
            margin-left: 10px;
            font-size: 25px;
        }
        #search input{
            margin-left: 10px;
            font-size: 25px;
        }
        .add{
            text-align: center;
        }
        .add a span{
            color: forestgreen;
            font-size: 20px;
        }
        .biaoge table{
            margin:auto;
            height: 250px;
            width: 600px;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="search">
    <form action="${pageContext.request.contextPath}/selectByClassNameOrName" method="post" enctype="multipart/form-data" >
        <span>班级</span><select name="className" >
            <option name="className" value="全部">全部</option>
            <option name="className" value="计科一班">计科一班</option>
            <option name="className" value="计科二班">计科二班</option>
            <option name="className" value="软件一班">软件一班</option>
            <option name="className" value="软件二班">软件二班</option>
        </select>
        <span>姓名</span><input type="text" name="name"/>
        <input type="submit" value="查询">
    </form></div><br>
<div class="add"><a href="update.jsp"><span>添加学生</span></a></div><br>
<div class="biaoge">
<table border="1" cellSpacing="0">
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>班级</th>
        <th>头像</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.score}</td>
            <td>${student.className}</td>
            <td style="width: 120px" height="60px"><c:if test="${student.head !=null }">
                <img alt="" src="${pageContext.request.contextPath}/${student.head }" height="100%" width="100%">
            </c:if> </td>
            <td>
                <a href="queryById?id=${student.id}"><span style="color: forestgreen">编辑</span></a>
                <a href="deleteById?id=${student.id}"><span style="color: forestgreen">删除</span></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
