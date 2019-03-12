<%-- 
    Document   : index
    Created on : 11 mars 2019, 23 h 28 min 59 s
    Author     : Orann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s8 offset-s2">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Bienvenue sur notre application web de gestion de parc d'attraction !</span>
                <a href="${pageContext.request.contextPath}/login/">Cliquer ici pour vous connecter</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>
