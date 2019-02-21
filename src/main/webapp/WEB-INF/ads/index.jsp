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
    <h1 class="title">Here Are all the ads!</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6 zoom"
             style="display: inline-block;padding:10px;max-width:45%">
            <h2 class="title3">${ad.title}</h2>
            <p class="description">${ad.description}</p>
            <%--This anchor tag redirects to the ViewAdServlet while also stashing the ID of it's associated ad in the session--%>
            <a href="/ads/view?id=${ad.id}">View Details</a>
        </div>
    </c:forEach>
</div>

</body>
</html>
