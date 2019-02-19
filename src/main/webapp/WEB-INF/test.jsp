<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ryanglazer
  Date: 2019-02-16
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Test" />
    </jsp:include>
</head>
<body>
    <h1>Search Test</h1>
    <form action="/test" method="post">
        <div class="form-group">
            <label for="tester">Enter search query</label>
            <input id="tester" name="tester" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</body>
</html>
