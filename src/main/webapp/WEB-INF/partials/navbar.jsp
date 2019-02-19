<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/partials/jsScripts.jsp"/>
        <style>

            .overlay
            {
                height: 100%;
                width: 0;
                position: fixed;
                z-index: 1;
                top: 0em;
                left: 0em;
                background-color: rgb(0,0,0);
                background-color: rgba(0,0,0, 0.9);
                overflow-x: hidden;
                transition: 0.5s;
            }

            .overlay-content
            {
                position: relative;
                top: 25%;
                width: 35%;
                text-align: right;
                margin-top: 30px;
            }

            .overlay a
            {
                position: relative;
                padding: 8px;
                text-decoration: none;
                font-size: 36px;
                color: #818181;
                display: block;
                top: -2em;
                left: 1em;
                transition: 0.3s;
            }

            .overlay a:hover, .overlay a:focus
            {
                color: black;
            }

            .overlay .closebtn
            {
                position: fixed;
                top: 0em;
                right: 9em;
                font-size: 60px;
            }

            @media screen and (max-height: 1080px)
            {
                .overlay a {font-size: 2.5em}
                .overlay .closebtn
                {
                    font-size: 40px;
                    top: 0em;
                    right: 11em;
                    left: 11em;
                }
            }

            #span-cust
            {
                position: fixed;
                left: 0.5em;
                top: 0em;
                color:white;
            }

            #search-cust
            {
                position: relative;
                top: -34.9em;
                left: 2em;
                right: 4em;
            }

            #searchbtn-cust
            {
                position: relative;
                top: -37.2em;
                left: 7em;
                right: 4em;
            }

        </style>





<%--CREATE DYNAMIC GREETING FOR SLIDE OUT NAV BAR THAT GREETS USERNAME--%>


<nav class="navbar nav-custom navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-left">

            <div id="myNav" class="overlay">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <div class="overlay-content">
                    <a class="anchorHover" style="width: 4.5em;" href="/ads">
                        View Ads
                    </a>
                    <a class="anchorHover" style="width: 5.6em;" href="/profile">
                        View Profile
                    </a>
                    <a class="anchorHover" style="width: 5.1em;" href="/ads/create">
                        Create Ad
                    </a>
                    <a class="anchorHover" style="width: 4.1em;" href="#">
                        Contact
                    </a>
                    <input id="search-cust" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button id="searchbtn-cust" class="search-cust btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
                </div>
            </div>
            <span id="span-cust" style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
            <a href="/">
            <h1>
                <span id="under">
                    Under
                </span>
                <span id="dogs">
                    Dogs!
                </span>
            </h1>
            </a>
        </div>
        <h3 id="subheading">
            The C-List Superhero Job Board
        </h3>
        <div class="nav navbar-nav navbar-right">
            <div class="navbar-right">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                        <a id="logout-cust" href="/logout">
                            Logout
                        </a>
                </c:when>
                <c:otherwise>
                    <div class="navbar-right">
                        <a class="anchorHover badge badge-primary" id="reg-cust" href="register">
                            Register
                        </a>
                        <a class="anchorHover badge badge-primary" id="login-cust" href="login">
                            Login
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>
            </div>

        </div>
    </div>
</nav>



