<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/main.css" type="text/css">
<%--<nav class="navbar navbar-default">--%>
    <%--<div class="container-fluid">--%>
        <%--<!-- Brand and toggle get grouped for better mobile display -->--%>
        <%--<div class="navbar-header">--%>
            <%--<a class="navbar-brand" href="/ads">--%>
                <%--Adlister--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<ul class="nav navbar-nav navbar-right">--%>
<%--<li><a href="/login">Login</a></li>--%>
<%--<li><a href="/logout">Logout</a></li>--%>
<%--</ul>--%>
<%--</div><!-- /.navbar-collapse -->--%>
<%--</div><!-- /.container-fluid -->--%>
<%--</nav>--%>

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
                color: #f1f1f1;
            }

            .overlay .closebtn
            {
                position: relative;
                top: 0em;
                right: 9em;
                font-size: 60px;
            }

            @media screen and (max-height: 1440px)
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
            }
        </style>

<nav class="navbar nav-custom navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-left">

            <div id="myNav" class="overlay">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <div class="overlay-content">
                    <a href="#">
                        Adlister
                    </a>
                    <a href="#">
                        Search by Username
                    </a>
                    <a href="#">
                        Search by catagorey
                    </a>
                    <a href="#">
                        Contact
                    </a>
                </div>
            </div>
            <span id="span-cust" style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>



            <h1>
                <span id="under">
                    Under
                </span>
                <span id="dogs">
                    Dogs!
                </span>
            </h1>
        </div>
        <h3 id="subheading" style="text-align: center">
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
                        <a class="badge badge-primary" id="reg-cust" href="/register">
                            Register
                        </a>
                        <a class="badge badge-primary" id="login-cust" href="/login">
                            Login
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>
            </div>

        </div>
    </div>
</nav>




                <%--<nav class="navbar navbar-default navbar-fixed-top mainmenu">--%>
                    <%--<div class="container-fluid">--%>
                        <%--<div class="navbar-header">--%>
                            <%--<a class="navbar-brand" href="#">LOGO<br>HERE</a>--%>
                            <%--<div class="custom-menu">--%>
                                <%--<ul class="nav navbar-nav tool-items">--%>
                                    <%--<li class="icon-link"><a href="#"><span>Our jobs</span></a></li>--%>
                                    <%--<li class="lang-picker">--%>
                                        <%--<div class="lang lang-current">   <a href="#">EN <span class="caret"></span></a>--%>
                                        <%--</div>--%>
                                        <%--<div class="lang list">--%>
                                            <%--<a href="#">LT</a>--%>
                                        <%--</div>--%>
                                    <%--</li>--%>
                                <%--</ul>--%>
                            <%--</div>--%>
                            <%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">--%>
                                <%--<span class="icon-bar"></span>--%>
                                <%--<span class="icon-bar"></span>--%>
                                <%--<span class="icon-bar"></span>--%>
                            <%--</button>--%>
                        <%--</div>--%>
                        <%--<div class="collapse navbar-collapse" id="myNavbar">--%>
                            <%--<ul class="nav navbar-nav">--%>
                                <%--<li class="active"><a href="about.html" class="nav-link">About Us</a></li>--%>
                                <%--<li><a href="case-studies.html" class="nav-link">Case Studies</a></li>--%>
                                <%--<li><a href="product-overview.html" class="nav-link">Solutions</a></li>--%>
                                <%--<li><a href="services.html" class="nav-link">Services</a></li>--%>
                                <%--<li><a href="prices.html" class="nav-link">Pricing</a></li>--%>
                                <%--<li><a href="blog.html" class="nav-link">News</a></li>--%>
                                <%--<li><a href="order-form.html" class="nav-link">Send Query</a></li>--%>
                                <%--<li><a href="contacts.html" class="nav-link">Contacts</a></li>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</nav>--%>



<%--<nav class="navbar navbar-dark bg-danger">--%>
    <%--<a class="navbar-brand" href="#">--%>
        <%--Never expand--%>
    <%--</a>--%>
    <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContentNV" aria-controls="navbarSupportedContentNV" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>

    <%--<div class="collapse navbar-collapse" id="navbarSupportedContentNV">--%>
        <%--<ul class="navbar-nav mr-auto">--%>
            <%--<li class="nav-item active">--%>
                <%--<a class="nav-link" href="#">--%>
                    <%--Home--%>
                    <%--<span class="sr-only">--%>
                        <%--(current)--%>
                    <%--</span>--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="#">--%>
                    <%--Link--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownNV" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                    <%--Dropdown--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu" aria-labelledby="navbarDropdownNV">--%>
                    <%--<a class="dropdown-item" href="#">--%>
                        <%--Action--%>
                    <%--</a>--%>
                    <%--<a class="dropdown-item" href="#">--%>
                        <%--Another action--%>
                    <%--</a>--%>
                    <%--<div class="dropdown-divider"></div>--%>
                    <%--<a class="dropdown-item" href="#">--%>
                        <%--Something else here--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link disabled" href="#">--%>
                    <%--Disabled--%>
                <%--</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
        <%--<form class="form-inline my-2 my-lg-0">--%>
            <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
            <%--<button class="btn btn-outline-dark my-2 my-sm-0" type="submit">--%>
                <%--Search--%>
            <%--</button>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</nav>--%>




<%--<nav class="navbar navbar-fixed-top navbar-dark bg-primary">--%>
    <%--<div class="container">--%>
        <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar2" aria-controls="exCollapsingNavbar2" aria-expanded="false" aria-label="Toggle navigation">--%>
            <%--&#9776;--%>
        <%--</button>--%>
        <%--<div class="collapse navbar-toggleable" id="exCollapsingNavbar2">--%>
            <%--<div class="nav-item">--%>
                <%--<a class="navbar-brand nav-link" href="#">IMGS</a>--%>
            <%--</div>--%>

            <%--<ul class="nav navbar-nav">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="#">About</a>--%>
                <%--</li>--%>

                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="#">Contact</a>--%>
                <%--</li>--%>
            <%--</ul>--%>

            <%--<ul class="nav navbar-nav">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-item nav-link" href="#">Sign Up</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-item nav-link" href="#">Login</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js" integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js" integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB" crossorigin="anonymous"></script>--%>
<%--=--%>


<%--<!DOCTYPE html>--%>
<%--<html>--%>
    <%--<head>--%>
        <%--&lt;%&ndash;<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">&ndash;%&gt;--%>

    <%--</head>--%>
    <%--<body>--%>





            <%--</div>--%>
        <%--</div>--%>
    <%--</div><!-- /.navbar-collapse -->--%>
    <%--</div><!-- /.container-fluid -->--%>

<%--</nav>--%>
