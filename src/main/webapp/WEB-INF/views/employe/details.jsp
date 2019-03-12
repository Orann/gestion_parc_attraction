<%-- 
    Document   : details
    Created on : 12 mars 2019, 14 h 58 min 41 s
    Author     : Orann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s9 offset-s1">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Détail de l'employé ${personne_employe.personne.prenom} :</span>
                <a href="${pageContext.request.contextPath}/employe/">Retour</a>
                
                <div class="row">
                    <div class="">
                        <table class="striped centered responsive-table">
                            <tr>
                                <th>ID</th>
                                <th>Prénom</th> 
                                <th>Nom</th>
                                <th>Login</th>
                                <th>Type</th>
                                <th>Adresse</th>
                                <th>Age</th>
                                <th>Salaire</th>
                            </tr>
                            <tr>
                                <td>${personne_employe.personne.id_personne}</td>
                                <td>${personne_employe.personne.prenom}</td> 
                                <td>${personne_employe.personne.nom}</td>
                                <td>${personne_employe.employe.login}</td>
                                <td>${personne_employe.employe.type}</td>
                                <td>${personne_employe.employe.adresse}</td>
                                <td>${personne_employe.employe.age}</td>
                                <td>${personne_employe.employe.salaire}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>
