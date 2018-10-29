<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>jstl标签</title>
</head>
<body>
    <!-- c:分支判断 test：中支持使用el表达式 -->
    <!--  单分支  -->
    <%
        request.setAttribute("score",90);

        List list = new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        request.setAttribute("lists",list);
    %>
    <c:if test="${score > 80}">
        奖励一个大红花
    </c:if>
    <!--  多分支  -->
    <c:choose>
        <c:when test="${score > 80}">奖励大红花</c:when>
        <c:when test="${score > 60}">奖励小红花</c:when>
        <c:otherwise>奖励大大巴掌</c:otherwise>
    </c:choose>

    <!--  循环  item(支持el):遍历的内容  var:每个遍历元素的名称 -->
    <c:forEach items="${lists}" var="list">
        <p>${list}</p>
    </c:forEach>
</body>
</html>
