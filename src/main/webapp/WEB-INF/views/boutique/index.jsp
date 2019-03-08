<%-- 
    Document   : index
    Created on : 23 févr. 2019, 22 h 59 min 14 s
    Author     : Pierre
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
                <span class="card-title">Liste des boutiques :</span>
                <a href="${pageContext.request.contextPath}/boutique/add">Ajouter une nouvelle boutique</a>
                <div class="row">
                    <div class="col s8 offset-s2">
                        <table class="striped centered responsive-table">
                            <tr>
                                <th>ID</th>
                                <th>Nom</th> 
                                <th>Type</th>
                            </tr>
                            <c:forEach var="boutique" items="${boutique}">
                                <tr>
                                    <td>${boutique.id}</td>
                                    <td>${boutique.nom}</td> 
                                    <td>${boutique.type}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/boutique/edit/${boutique.id}">Modifier</a>
                                        <a href="${pageContext.request.contextPath}/boutique/delete/${boutique.id}">Supprimer</a>
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

