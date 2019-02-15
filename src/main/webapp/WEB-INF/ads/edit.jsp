<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ryanglazer
  Date: 2019-02-15
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Ad"/>
    </jsp:include>
</head>
<body>
    <h1>It Works</h1>
    <form action="/ads/edit" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${editAD.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control"
                      type="text">${editAD.description}</textarea>
        </div>
        <input name="IDEdit" id="IDEdit" value="${editAD.id}" hidden>
        <%--<div class="form-group">--%>
            <%--<c:forEach var="cat" items="${cats}">--%>
                <%--&lt;%&ndash;<div <c:when test="ad = ${ad.adalreadycheckedlist} "  selected> </div>&ndash;%&gt;--%>
                <%--<label for=cat>Test</label>--%>
                <%--<input type="checkbox" name="checkbox2" id="checkbox2" value="Test2">--%>

            <%--</c:forEach>--%>
        <%--</div>--%>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</body>
</html>
