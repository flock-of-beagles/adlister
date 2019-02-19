<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ryanglazer
  Date: 2019-02-14
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="View Ad" />
    </jsp:include>
</head>
<body>
    <h1>It's Working</h1>
        <div class="col-md-6">
            <h2>${specAd.title}</h2>
            <p>${specAd.description}</p>
            <c:if test="${testList.contains(1)}">
                <p>Working</p>
            </c:if>
        </div>
</body>
</html>