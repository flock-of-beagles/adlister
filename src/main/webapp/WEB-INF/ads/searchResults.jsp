<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Results</h1>
        <c:forEach var="ad" items="${SearchAds}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                    <%--This anchor tag redirects to the ViewAdServlet while also stashing the ID of it's associated ad in the session--%>
                <a href="/ads/view?id=${ad.id}">View Details</a>
            </div>
        </c:forEach>
    </div>

</body>
</html>
