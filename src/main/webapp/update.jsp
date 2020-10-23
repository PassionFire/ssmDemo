<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24 0024
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .update span{
            font-size: 28px;
            color: cornflowerblue;
        }
        .update input{
            width: 220px;
            height: 40px;
        }
        .update select{
            width: 220px;
            height: 40px;
        }
        .update select option{
            font-size: 20px;
        }

        .add_1 span{
             font-size: 28px;
             color: cornflowerblue;
         }
        .add_1 input{
            width: 220px;
            height: 40px;
        }
        .add_1 select{
            width: 220px;
            height: 40px;
        }
        .add_1 select option{
            font-size: 20px;
        }
    </style>
</head>
<body>
<!--编辑-->
<c:if test="${student.id !=null}">
    <div class="update">
    <form action="${pageContext.request.contextPath}/edit" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${student.id}">
        <span>姓名:</span><input type="text" name="name" value="${student.name}"> <br>
        <span>成绩:</span><input type="text" name="score" value="${student.score}"> <br>
        <span>班级:</span><select name="className" id="className">
        <c:if test="${student.className eq '计科一班'}">
            <option name="className" value="计科一班" selected>计科一班</option>
            <option name="className" value="计科二班">计科二班</option>
            <option name="className" value="软件一班">软件一班</option>
            <option name="className" value="软件二班">软件二班</option>
        </c:if>
        <c:if test="${student.className eq '计科二班'}">
            <option name="className" value="计科一班">计科一班</option>
            <option name="className" value="计科二班" selected>计科二班</option>
            <option name="className" value="软件一班">软件一班</option>
            <option name="className" value="软件二班">软件二班</option>
        </c:if>
        <c:if test="${student.className eq '软件一班'}">
            <option name="className" value="计科一班">计科一班</option>
            <option name="className" value="计科二班">计科二班</option>
            <option name="className" value="软件一班" selected>软件一班</option>
            <option name="className" value="软件二班">软件二班</option>
        </c:if>
        <c:if test="${student.className eq '软件二班'}">
            <option name="className" value="计科一班">计科一班</option>
            <option name="className" value="计科二班">计科二班</option>
            <option name="className" value="软件一班">软件一班</option>
            <option name="className" value="软件二班" selected>软件二班</option>
        </c:if>
    </select><br>
        <span>头像:</span><input type="file" name="file">
        <c:if test="${student.head !=null }">
        <img alt="" src="${pageContext.request.contextPath}/${student.head }" style="width: 120px" height="60px">
        </c:if>
        <br>
        <input type="submit" value="修改">
    </form>
    </div>
</c:if>

<!--增加-->
<c:if test="${student.id ==null}">
    <div class="add_1">
    <form action="${pageContext.request.contextPath}/add" method="post" enctype="multipart/form-data">
        <span>姓名:</span><input type="text" name="name"> <br>
        <span>成绩:</span><input type="text" name="score"> <br>
        <span>班级:</span><select name="className"><option name="className">计科一班</option><option name="className">计科二班</option>
        <option name="className">软件一班</option><option name="className">软件二班</option></select><br>
        <span>头像:</span><input type="file" name="file"><br>
        <input type="submit" value="添加">
    </form>
    </div>
</c:if>
</body>
</html>
