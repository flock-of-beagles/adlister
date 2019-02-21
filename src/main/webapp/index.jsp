<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head >
    <jsp:include page="WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="WEB-INF/partials/navbar.jsp" />
        <br>
    <div class="container">
        <!-- Stack the columns on mobile by making one full-width and the other half-width -->
        <div class="row">
            <div class="zoom col-6 col-md-6 splash shadow-lg p-3 mb-5">

                <div class="card" style="align-content: center">
                <a class="indexAnchor" href="/search/result?SearchID=1">
                    <div class="card-body">
                        <h3 class="card-title" style="color:#d05702">
                            Assembling a Team?
                        </h3>
                        <h4 class="card-subtitle mb-2 text-muted">
                            See all superhero teams
                        </h4>
                        <img id = "team" src="images/superhero-team.png" style="width:80%; height:40%">
                            <br>
                        <p class="card-text">
                            Our greatest superpower is being a part of a super team.
                      </p>
                    </div>
                </a>
                </div>
            </div>

            <div class="zoom rounded col-6 col-md-6 splash shadow-lg p-3 mb-5">
                <a class="indexAnchor" href="/search/result?SearchID=2">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title" style="color:#0060be">
                            Looking to recruit a hero?
                        </h3>
                        <h4 class="card-subtitle mb-2 text-muted">
                            Find heroes looking for work.
                        </h4>
                        <img id = "unemployed" src="images/superhero.jpg">
                        <br>
                        <p class="card-text">
                            Sometimes great heroes just need great opportunities.
                        </p>
                    </div>
                </div>
                </a>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/partials/jsScripts.jsp"/>
</body>
</html>
