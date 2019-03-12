<%-- 
    Document   : header
    Created on : 25 févr. 2019, 18 h 02 min 05 s
    Author     : Orann
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <!--Import Google Icon Font-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <title>${title}</title>
    </head>

    <body>
    <nav class="light-blue lighten-1" role="navigation">
        <div class="nav-wrapper valign-wrapper">
            <a href="#" class="brand-logo center">Gestion de parc d'attraction</a>
            <c:if test="${title == 'Accueil' || title == 'Connexion'}">
                <a href="${pageContext.request.contextPath}/" class="brand-logo center">Gestion de parc d'attraction</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="${pageContext.request.contextPath}/login/">Connexion</a></li>
                </ul>
            </c:if>
            <c:if test="${title != 'Accueil' && title != 'Connexion'}">
                <a href="${pageContext.request.contextPath}/employe/" class="brand-logo center">Gestion de parc d'attraction</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="${pageContext.request.contextPath}/deconnexion">Déconnexion</a></li>
                </ul>
            </c:if>
        </div>
    </nav>
    
