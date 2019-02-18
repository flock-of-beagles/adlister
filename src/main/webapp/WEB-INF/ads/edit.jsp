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
    <c:if test="${emptyField==1}">
        <h1 class="warning">Both Title and Description must be filled</h1>
    </c:if>
    <form action="/ads/edit" method="post">
        <div class="form-group">
            <label for="editTitle">Title</label>
            <input id="editTitle" name="editTitle" class="form-control" type="text" value="${editTitle}">
        </div>
        <div class="form-group">
            <label for="editDescription">Description</label>
            <textarea id="editDescription" name="editDescription" class="form-control"
                      type="text">${editDescription}</textarea>
        </div>
        <input name="IDEdit" id="IDEdit" value="${editAD.id}" hidden>
        <%--<div class="form-group">--%>
            <%--<c:forEach var="cat" items="${cats}">--%>
                <%--&lt;%&ndash;<div <c:when test="ad = ${ad.adalreadycheckedlist} "  selected> </div>&ndash;%&gt;--%>
                <%--<label for=cat>Test</label>--%>
                <%--<input type="checkbox" name="checkbox2" id="checkbox2" value="Test2">--%>

            <%--</c:forEach>--%>
        <%--</div>--%>
        <div class="form-group">
            <label for="editCheckbox1">Categories</label>
            <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
            <input type="checkbox" name="editCheckbox1" id="editCheckbox1" value="Test1" <c:if test="${category1==1}">checked</c:if>>
            <label for="editCheckbox2">Test</label>
            <input type="checkbox" name="editCheckbox2" id="editCheckbox2" value="Test2"<c:if test="${category2==1}">checked</c:if>>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</body>
</html>
