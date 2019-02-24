<%-- 
    Document   : index
    Created on : 23 févr. 2019, 22 h 59 min 14 s
    Author     : Orann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <!-- Compiled and minified CSS -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
            <title>Gestion Parc Attraction</title>
        </head>

        <body>
        <nav class="light-blue lighten-1" role="navigation">
            <div class="nav-wrapper valign-wrapper">
                <a href="#" class="brand-logo center">Gestion de parc d'attraction</a>
            </div>
        </nav>
        <div class="row">
            <div class="col s8 offset-s2">
                <div class="card">
                    <div class="card-content">
                        <span class="card-title">Liste des personnes :</span>
                        <div class="row">
                            <div class="col s8 offset-s2">
                                <table class="striped centered responsive-table">
                                    <tr>
                                        <th>ID</th>
                                        <th>Prénom</th> 
                                        <th>Nom</th>
                                        <th>Action</th>
                                    </tr>
                                    <c:forEach var="personne" items="${personnes}">
                                        <tr>
                                            <td>${personne.id}</td>
                                            <td>${personne.prenom}</td> 
                                            <td>${personne.nom}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/personne/edit/${personne.id}">Modifier</a>
                                                <a href="${pageContext.request.contextPath}/personne/delete/${personne.id}">Supprimer</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>


    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</html>
</f:view>
