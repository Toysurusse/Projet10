<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title><decorator:title default="Struts Starter"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Website Library">
    <meta name="author" content="ToysuRusse">

    <title>Accueil</title>

    <!-- Bootstrap core CSS -->
    <link href="../../startbootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../startbootstrap/css/full-width-pics.css" rel="stylesheet">

    <decorator:head/>

</head>
<body id="page-home">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Library Rent</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse navbar-dark" id="navbarResponsive">
            <ul class="navbar-nav navbar-dark ml-auto">
                <li class="nav-item active">
                    <s:if test="#session.user">
                        <div class="row">
                        <s:a action="disconnect" class="nav-link">Déconnecter <s:property value="#session.user.pseudo"/></s:a>
                        </div>
                    </s:if>
                    <s:else>
                        <s:a action="connect" class="nav-link">Se Connecter</s:a>
                    </s:else>
                </li>
                <li class="nav-item">
                    <s:if test="#session.user">
                    </s:if>
                    <s:else>
                        <a class="nav-link" href="connect.action">Contact</a>
                    </s:else>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header - set the background image for the header in the line below -->
<header class="py-5 bg-image-full" style="background-image: url('https://unsplash.it/1900/1080?image=1076');">
    <img class="img-fluid d-block mx-auto" src="../../picture/book.JPG" alt="">
</header>

<decorator:body/>


<!-- Image Section - set the background image for the header in the line below -->
<section class="py-5 bg-image-full" style="background-image: url('https://unsplash.it/1900/1080?image=1081');">
    <!-- Put anything you want here! There is just a spacer below for demo purposes! -->
    <div style="height: 200px;"></div>
</section>

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="../../startbootstrap/vendor/jquery/jquery.min.js"></script>
<script src="../../startbootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
