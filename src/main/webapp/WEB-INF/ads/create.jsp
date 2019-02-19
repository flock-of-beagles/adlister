<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <div class="container">
        <c:if test="${emptyFields==1}">
            <h1>Title and Description must have text</h1>
        </c:if>
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" value="${createTitle}">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text">${createDescription}</textarea>
            </div>
            <%--Checkboxes for categories--%>
            <%--TODO Finalize categories--%>
            <div class="form-group">
                <label for="checkbox1">Local</label>
                <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
                <input type="checkbox" name="checkbox1" id="checkbox1" value="1">
                <label for="checkbox2">Regional</label>
                <input type="checkbox" name="checkbox2" id="checkbox2" value="2">
                <label for="checkbox3">National</label>
                <input type="checkbox" name="checkbox3" id="checkbox3" value="3">
                <label for="checkbox4">Global</label>
                <input type="checkbox" name="checkbox4" id="checkbox4" value="4">
                <br>
                <label for="checkbox5">Emerging</label>
                <input type="checkbox" name="checkbox5" id="checkbox5" value="5">
                <label for="checkbox6">Established</label>
                <input type="checkbox" name="checkbox6" id="checkbox6" value="6">
                <br>
                <label for="checkbox7">Amateur</label>
                <input type="checkbox" name="checkbox7" id="checkbox7" value="7">
                <label for="checkbox8">Experienced</label>
                <input type="checkbox" name="checkbox8" id="checkbox8" value="8">
                <label for="checkbox9">Professional</label>
                <input type="checkbox" name="checkbox9" id="checkbox9" value="9">
                <br>
                <label for="checkbox10">Looking for Team</label>
                <input type="checkbox" name="checkbox10" id="checkbox10" value="10">
                <label for="checkbox11">Looking for Member</label>
                <input type="checkbox" name="checkbox11" id="checkbox11" value="11">
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
