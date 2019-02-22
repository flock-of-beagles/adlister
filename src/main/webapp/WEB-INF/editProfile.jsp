<%--
  Created by IntelliJ IDEA.
  User: ryanglazer
  Date: 2019-02-21
  Time: 09:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../WEB-INF/partials/navbar.jsp" />
    <h1 class="title2">
        Edit Profile
    </h1>
    <form id="editProfileForm" action="/profile/edit" method="post">
        <div class="form-group">
            <label class="formLabels" for="username">
                New Username
            </label>
            <input id="username" name="username" class="inputFont form-control" type="text" value="${user.username}">
        </div>
        <div class="form-group">
            <label class="formLabels" for="email">
               New Email
            </label>
            <input id="email" name="email" class="inputFont form-control" type="text" value="${user.username}">
        </div>
        <div class="form-group">
            <label class="formLabels" for="password">
               New Password
            </label>
            <input id="password" name="password" class="inputFont form-control" type="password">
        </div>
        <div class="form-group">
            <label class="formLabels" for="confirm_password">
                Confirm New Password
            </label>
            <input id="confirm_password" name="confirm_password" class="inputFont form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</body>
</html>
