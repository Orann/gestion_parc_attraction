<%-- 
    Document   : index
    Created on : 11 mars 2019, 23 h 28 min 59 s
    Author     : Pierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s8 offset-s2">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Bonjour ${cookieLogin}</span>
                <c:if test="${cookieType == 'Administrateur'}">
                    <br><a href="${pageContext.request.contextPath}/attraction/">Acceder aux attractions</a>
                    <br><a href="${pageContext.request.contextPath}/boutique/">Acceder aux boutiques</a>
                    <br><a href="${pageContext.request.contextPath}/employe/">Acceder aux employes</a>
                    <br><a href="${pageContext.request.contextPath}/client/">Acceder aux clients</a>
                </c:if>
                <c:if test="${cookieType == 'Gerant_des_attractions'}">
                    <a href="${pageContext.request.contextPath}/attraction/">Acceder aux attractions</a>
                </c:if>
                <c:if test="${cookieType == 'Gerant_des_boutiques'}">
                    <a href="${pageContext.request.contextPath}/boutique/">Acceder aux boutiques</a>
                </c:if>
                <c:if test="${cookieType == 'Gerant_du_personnel'}">
                    <a href="${pageContext.request.contextPath}/employe/">Acceder au personnel</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>
