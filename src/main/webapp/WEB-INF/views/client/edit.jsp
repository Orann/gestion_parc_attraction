<%-- 
    Document   : edit
    Created on : 25 févr. 2019, 19 h 45 min 07 s
    Author     : Orann
--%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s8 offset-s2">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Modification de ${personne.prenom} ${personne.nom}</span>
                <f:form method="post" modelAttribute = "personne_client" class = "s12"
                        action = "${pageContext.request.contextPath}/client/edit">
                    <div class="row">
                        <div class="input-field col s3">
                            <f:input path="personne.prenom" id="prenom" type="text" class="validate"/>
                            <label for="prenom">Prénom</label>
                        </div>
                        <div class="input-field col s3">
                            <f:input path="personne.nom" id="nom" type="text" class="validate"/>
                            <label for="nom">Nom</label>
                        </div>
                        <div class="input-field col s3">
                            <f:input path="client.nombre_demi_journee" id="nombre_demi_journee" type="number" placeholder="0" class="validate"/>
                            <label for="nombre_demi_journee">Nombre de demi-journée</label>
                        </div>
                            <div class="input-field col s3">
                            <f:input path="client.prix_paye" id="prix_paye" type="text" class="validate"/>
                            <label for="prix_paye">Prix encaissé</label>
                        </div>
                    </div>
                    <f:hidden path="personne.id_personne"/>
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
