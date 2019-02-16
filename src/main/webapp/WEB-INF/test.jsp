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
    <form action="/test" method="post">
        <div class="form-group">
            <label for="tester">Type Yes to redirect, anything else to test sticky forms</label>
            <input id="tester" name="tester" class="form-control" type="text" value="${tester}">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</body>
</html>
