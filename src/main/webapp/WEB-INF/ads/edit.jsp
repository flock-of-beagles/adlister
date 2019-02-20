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
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <h1 class="title3">Edit This Ad</h1>
    <c:if test="${emptyField==1}">
        <h1 class="warning">Both Title and Description must be filled</h1>
    </c:if>
    <form id="editForm" action="/ads/edit" method="post">
        <div class="form-group">
            <label class="label3" for="editTitle">Title</label>
            <input id="editTitle" name="editTitle" class="form-control" type="text" value="${editTitle}">
        </div>
        <div class="form-group">
            <label class="label3" for="editDescription">Description</label>
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
            <label class="label2" for="checkbox1">Local</label>
            <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
            <input type="checkbox" name="checkbox1" id="checkbox1" value="1" <c:if test="${category1==1}">checked</c:if>>
            <label class="label2" for="checkbox2">Regional</label>
            <input type="checkbox" name="checkbox2" id="checkbox2" value="2" <c:if test="${category2==1}">checked</c:if>>
            <label class="label2" for="checkbox3">National</label>
            <input type="checkbox" name="checkbox3" id="checkbox3" value="3" <c:if test="${category3==1}">checked</c:if>>
            <label class="label2" for="checkbox4">Global</label>
            <input type="checkbox" name="checkbox4" id="checkbox4" value="4" <c:if test="${category4==1}">checked</c:if>>
            <br>
            <label class="label2" for="checkbox5">Emerging</label>
            <input type="checkbox" name="checkbox5" id="checkbox5" value="5" <c:if test="${category5==1}">checked</c:if>>
            <label class="label2" for="checkbox6">Established</label>
            <input type="checkbox" name="checkbox6" id="checkbox6" value="6" <c:if test="${category6==1}">checked</c:if>>
            <br>
            <label class="label2" for="checkbox7">Amateur</label>
            <input type="checkbox" name="checkbox7" id="checkbox7" value="7" <c:if test="${category7==1}">checked</c:if>>
            <label  class="label2" for="checkbox8">Experienced</label>
            <input type="checkbox" name="checkbox8" id="checkbox8" value="8" <c:if test="${category8==1}">checked</c:if>>
            <label  class="label2" for="checkbox9">Professional</label>
            <input type="checkbox" name="checkbox9" id="checkbox9" value="9" <c:if test="${category9==1}">checked</c:if>>
            <br>
            <label class="label2" for="checkbox10">Looking for Team</label>
            <input type="checkbox" name="checkbox10" id="checkbox10" value="10" <c:if test="${category10==1}">checked</c:if>>
            <label class="label2" for="checkbox11">Looking for Member</label>
            <input type="checkbox" name="checkbox11" id="checkbox11" value="11" <c:if test="${category11==1}">checked</c:if>>
            <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</body>
</html>
