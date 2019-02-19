<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1 class="titleColor">
            Please fill in your information.
        </h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label class="formLabels" for="username">
                    Username
                </label>
                <input id="username" name="username" class="inputFont form-control" type="text">
            </div>
            <div class="form-group">
                <label class="formLabels" for="email">
                    Email
                </label>
                <input id="email" name="email" class="inputFont form-control" type="text">
            </div>
            <div class="form-group">
                <label class="formLabels" for="password">
                    Password
                </label>
                <input id="password" name="password" class="inputFont form-control" type="password">
            </div>
            <div class="form-group">
                <label class="formLabels" for="confirm_password">
                    Confirm Password
                </label>
                <input id="confirm_password" name="confirm_password" class="inputFont form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>