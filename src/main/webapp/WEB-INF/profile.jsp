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
        <h1 class="title2">Welcome, ${sessionScope.user.username}!</h1>
        <h1 class="title" style="color:#88959b;text-align:left">Here are all of your ads.</h1>
        <c:forEach var="ad" items="${profileAds}">
            <div class="col-md-6">
                <h2 class="title3" style="text-align:left;padding-left:0">${ad.title}</h2>
                <p class="description">${ad.description}</p>
                <%--Redirects to edit page while stashing ad to be edited ID in session--%>
                <a href="/ads/edit?editID=${ad.id}">Edit Ad</a>
                <a href="/delete?deleteID=${ad.id}"style="padding-left:4rem">Delete Ad</a>
            </div>
        </c:forEach>

    </div>

</body>
</html>
