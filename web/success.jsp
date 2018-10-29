<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/5
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%--request:${name}
application：${user2}
<a href="phone.jsp?name=${name}">手机</a>--%>
<!-- c:分支判断 test：中支持使用el表达式 -->
<%
    request.setAttribute("score",70);
%>
<c:if test="${score > 80}">
    奖励一个大红花
</c:if>
</body>
</html>
