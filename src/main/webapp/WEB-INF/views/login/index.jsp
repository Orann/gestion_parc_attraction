<%-- 
    Document   : index
    Created on : 6 mars 2019, 01 h 32 min 45 s
    Author     : Orann
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s6 offset-s3">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Connexion</span>
                <f:form method="post" modelAttribute = "employe"
                        action = "${pageContext.request.contextPath}/login/login">
                    <div class="row">
                        <div class="input-field">
                            <i class="material-icons prefix">account_circle</i>
                            <f:input path="login" id="login" type="text" class="validate"/>
                            <label for="login">Login</label>
                        </div>
                        <div class="input-field">
                            <i class="material-icons prefix">lock</i>
                            <f:input path="mot_de_passe" id="mot_de_passe" type="password" class="validate"/>
                            <label for="mot_de_passe">Mot de passe</label>
                        </div>
                    </div>
                    <div class="right-align">
                        <button class="btn waves-effect waves-light" value="creer" type="submit">Connexion
                                <i class="material-icons right">send</i>
                        </button>
                    </div>
                </f:form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>
