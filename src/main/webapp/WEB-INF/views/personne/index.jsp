<%-- 
    Document   : index
    Created on : 23 févr. 2019, 22 h 59 min 14 s
    Author     : Orann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s8 offset-s2">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Liste des personnes :</span>
                <a href="${pageContext.request.contextPath}/personne/add">Ajouter une nouvelle personne</a>
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
<%@ include file="../template/footer.jsp"%>

