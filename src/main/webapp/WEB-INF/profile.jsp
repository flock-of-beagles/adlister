<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <c:forEach var="ad" items="${profileAds}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <%--Redirects to edit page while stashing ad to be edited ID in session--%>
                <a href="/ads/edit?editID=${ad.id}">Edit Ad</a>
                <a href="/delete?deleteID=${ad.id}">Delete Ad</a>
            </div>
        </c:forEach>

    </div>

</body>
</html>
