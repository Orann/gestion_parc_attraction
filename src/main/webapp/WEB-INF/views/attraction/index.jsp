<%-- 
    Document   : index
    Created on : 23 févr. 2019, 22 h 59 min 14 s
    Author     : Pierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s8 offset-s2">
        <div class="card">
            <div class="card-content">
                <div class="input-field">
                    <f:input path="nom" id="nom" type="text" class="validate"/>
                    <label for="nom">Nom</label> 
                    <a href="${pageContext.request.contextPath}/attraction/search/${search}">Modifier</a>
                    <i class="material-icons">close</i>
                </div>
                <span class="card-title">Liste des attractions :</span>
                <a href="${pageContext.request.contextPath}/attraction/add">Ajouter une nouvelle attraction</a>
                <div class="row">
                    <div class="col s8 offset-s2">
                        <table class="striped centered responsive-table">
                            <tr>
                                <th>ID</th>
                                <th>Nom</th> 
                                <th>Type</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var="attraction" items="${attractions}">
                                <tr>
                                    <td>${attraction.id}</td>
                                    <td>${attraction.nom}</td> 
                                    <td>${attraction.type}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/attraction/edit/${attraction.id}">Modifier</a>
                                        <a href="${pageContext.request.contextPath}/attraction/delete/${attraction.id}">Supprimer</a>
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

