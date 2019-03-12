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
                <span class="card-title">Résultat de recherche pour ${nom} :</span>
                <div class="row">
                    <div class="col s8 offset-s2">
                        <table class="striped centered responsive-table">
                            <tr>
                                <th><center>ID</center></th>
                                <th><center>Prénom</center></th> 
                                <th><center>Nom</center></th>
                                <th><center>Login</center></th>
                                <th><center>Type</center></th>
                                <th><center>Action</center></th>
                            </tr>
                            <c:if test="${sizeE != 0}">
                                <c:forEach var = "i" begin = "0" end = "${sizeE-1}">
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
