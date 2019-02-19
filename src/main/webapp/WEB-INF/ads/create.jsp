<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1 class="title">Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label class="label" for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label class="label" for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <%--Checkboxes for categories--%>
            <%--TODO Finalize categories--%>
            <div class="form-group">
                <label class="label" for="checkbox1">Categories</label>
                <%--Checkboxes only send a value if they are checked, thus in servlets we can verfiy them by comparing them against null--%>
                <input type="checkbox" name="checkbox1" id="checkbox1" value="Test1">
                <label class="label" for="checkbox2">Test</label>
                <input type="checkbox" name="checkbox2" id="checkbox2" value="Test2">
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
