<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <br>
    <div class="container">
        <!-- Stack the columns on mobile by making one full-width and the other half-width -->
        <div class="row">
            <div class="col-6 col-md-4 splash">
                <div class="card" style="width: 24rem;align-content: center">
                    <div class="card-body">
                        <h3 class="card-title" style="width: 30rem; color:#d05702">Assembling a Team?</h3>
                        <h4 class="card-subtitle mb-2 text-muted">See all superhero teams</h4>
                        <img id = "team" src="images/team_thumb.jpeg" style="width:300px; height:200px">
                        <p class="card-text" style="font-size:1em">Our greatest superpower is being a part of a super team.</p>
                        <a href="#" class="card-link">Card link</a>
                        <a href="#" class="card-link">Another link</a>
                    </div>
                </div></div>
            <div class="col-6 col-md-4 splash">
                <div class="card" style="width: 24rem">
                    <div class="card-body">
                        <h3 class="card-title" style="width: 30rem; color:#d05702">Looking to recruit a hero? </h3>
                        <h4 class="card-subtitle mb-2 text-muted" style="width: 30rem">Find heroes looking for work.</h4>
                        <img id = "unemployed" src="images/unemployed_thumb.jpeg" style="width:300px; height:200px">
                        <p class="card-text" style="font-size:1em">Sometimes great heroes just need great opportunities.</p>
                        <a href="#" class="card-link">Card link</a>
                        <a href="#" class="card-link">Another link</a>
                    </div>
                </div>
            </div>
            <div class="col-6 col-md-4 splash">
                <div class="card" style="width: 24rem;align-content: center">
                    <div class="card-body">
                        <h3 class="card-title" style="width: 30rem; color:#d05702">Search the Job Board</h3>
                        <h4 class="card-subtitle mb-2 text-muted" style="width: 30rem">Card subtitle</h4>
                        <p class="card-text" style="font-size:1em">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="card-link">Card link</a>
                        <a href="#" class="card-link">Another link</a>
                    </div>
                </div>
            </div>
        </div>
<br><br>
    </div>
</body>
</html>
