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
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <h1>Search Test</h1>
    <form action="/search/result" method="post">
        <div class="form-group">
            <label for="search">Enter search query</label>
            <input id="search" name="search" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
        <br>
        <form action="/search/result" method="post">
            <%--Checkboxes for categories--%>
            <div class="form-group">
                <label  class="label2" for="checkbox1">Local</label>
                <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
                <input type="checkbox" name="checkbox1" id="checkbox1" value="1">
                <label  class="label2" for="checkbox2">Regional</label>
                <input type="checkbox" name="checkbox2" id="checkbox2" value="2">
                <label  class="label2" for="checkbox3">National</label>
                <input type="checkbox" name="checkbox3" id="checkbox3" value="3">
                <label  class="label2" for="checkbox4">Global</label>
                <input type="checkbox" name="checkbox4" id="checkbox4" value="4">
                <br>
                <label  class="label2" for="checkbox5">Emerging</label>
                <input type="checkbox" name="checkbox5" id="checkbox5" value="5">
                <label  class="label2" for="checkbox6">Established</label>
                <input type="checkbox" name="checkbox6" id="checkbox6" value="6">
                <br>
                <label  class="label2" for="checkbox7">Amateur</label>
                <input type="checkbox" name="checkbox7" id="checkbox7" value="7">
                <label  class="label2" for="checkbox8">Experienced</label>
                <input type="checkbox" name="checkbox8" id="checkbox8" value="8">
                <label  class="label2" for="checkbox9">Professional</label>
                <input type="checkbox" name="checkbox9" id="checkbox9" value="9">
                <br>
                <label  class="label2" for="checkbox10">Looking for Team</label>
                <input  type="checkbox" name="checkbox10" id="checkbox10" value="10">
                <label  class="label2" for="checkbox11">Looking for Member</label>
                <input type="checkbox" name="checkbox11" id="checkbox11" value="11">
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>

    </form>
</body>
</html>


