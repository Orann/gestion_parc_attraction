<%-- 
    Document   : edit
    Created on : 25 f�vr. 2019, 19 h 45 min 07 s
    Author     : Pierre
--%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s8 offset-s2">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Modification de ${boutique.nom}</span>
                <f:form method="post" modelAttribute = "boutique" class = "s12"
                        action = "${pageContext.request.contextPath}/boutique/edit">
                    <div class="row">
                        <div class="input-field col s6">
                            <f:input path="nom" id="nom" type="text" class="validate"/>
                            <label for="nom">Nom</label>
                        </div>
                        <div class="input-field col s6">
                            <f:select path="type" id="type" items="${type}"/>
                            <label for="type">Type</label>
                          </div>
                            <f:hidden path="id"/>
                    </div>
                    <div class="right-align">
                        <button class="btn waves-effect waves-light" value="creer" type="submit">Modifier
                                <i class="material-icons right">send</i>
                        </button>
                    </div>
                </f:form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>
