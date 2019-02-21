<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <c:if test="${testing != null}"><h1 class="titleColor">Edit Successful</h1></c:if>
        <h1 class="titleColor">
            Please Log In
        </h1>
        <form action="/login" method="POST">
            <div class="form-group">
                <label class="formLabels" for="username">
                    Username
                </label>
                <input id="username" name="username" class="form-control inputFont" type="text">
            </div>
            <div class="form-group">
                <label class="formLabels" for="password">
                    Password
                </label>
                <input id="password" name="password" class="form-control inputFont" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>
</body>
</html>