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
            <div class="form-group">
                <label for="checkbox1">Local</label>
                <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
                <input type="checkbox" name="checkbox1" id="checkbox1" value="1" <c:if test="${category1==1}">checked</c:if> disabled>
                <label for="checkbox2">Regional</label>
                <input type="checkbox" name="checkbox2" id="checkbox2" value="2" <c:if test="${category2==1}">checked</c:if> disabled>
                <label for="checkbox3">National</label>
                <input type="checkbox" name="checkbox3" id="checkbox3" value="3" <c:if test="${category3==1}">checked</c:if> disabled>
                <label for="checkbox4">Global</label>
                <input type="checkbox" name="checkbox4" id="checkbox4" value="4" <c:if test="${category4==1}">checked</c:if> disabled>
                <br>
                <label for="checkbox5">Emerging</label>
                <input type="checkbox" name="checkbox5" id="checkbox5" value="5" <c:if test="${category5==1}">checked</c:if> disabled>
                <label for="checkbox6">Established</label>
                <input type="checkbox" name="checkbox6" id="checkbox6" value="6" <c:if test="${category6==1}">checked</c:if> disabled>
                <br>
                <label for="checkbox7">Amateur</label>
                <input type="checkbox" name="checkbox7" id="checkbox7" value="7" <c:if test="${category7==1}">checked</c:if> disabled>
                <label for="checkbox8">Experienced</label>
                <input type="checkbox" name="checkbox8" id="checkbox8" value="8" <c:if test="${category8==1}">checked</c:if> disabled>
                <label for="checkbox9">Professional</label>
                <input type="checkbox" name="checkbox9" id="checkbox9" value="9" <c:if test="${category9==1}">checked</c:if> disabled>
                <br>
                <label for="checkbox10">Looking for Team</label>
                <input type="checkbox" name="checkbox10" id="checkbox10" value="10" <c:if test="${category10==1}">checked</c:if> disabled>
                <label for="checkbox11">Looking for Member</label>
                <input type="checkbox" name="checkbox11" id="checkbox11" value="11" <c:if test="${category11==1}">checked</c:if> disabled>
                <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
            </div>
        </div>
</body>
</html>
