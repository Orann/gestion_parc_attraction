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
                <span class="card-title">Liste des employés :</span>
                <a href="${pageContext.request.contextPath}/employe/add">Ajouter une nouvelle personne</a>
                ${cookies}
                <div class="row">
                    <div class="col s8 offset-s2">
                        <table class="striped centered responsive-table">
                            <tr>
                                <th>ID</th>
                                <th>Prénom</th> 
                                <th>Nom</th>
                                <th>Login</th>
                                <th>Type</th>
                                <th>Action</th>
                            </tr>
                            <c:if test="${size != 0}">
                                <c:forEach var = "i" begin = "0" end = "${size-1}">
                                    <tr>
                                        <td>${personnes.get(i).id_personne}</td>
                                        <td>${personnes.get(i).prenom}</td> 
                                        <td>${personnes.get(i).nom}</td>
                                        <td>${employes.get(i).login}</td>
                                        <td>${employes.get(i).type}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/employe/edit/${personnes.get(i).id_personne}">Modifier</a>
                                            <a href="${pageContext.request.contextPath}/employe/delete/${personnes.get(i).id_personne}">Supprimer</a>
                                            <a href="${pageContext.request.contextPath}/employe/details/${personnes.get(i).id_personne}">Détails</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>

