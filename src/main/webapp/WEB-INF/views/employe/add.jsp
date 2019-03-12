<%-- 
    Document   : add
    Created on : 25 févr. 2019, 18 h 33 min 21 s
    Author     : Orann
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../template/header.jsp"%>
<div class="row">
    <div class="col s8 offset-s2">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Ajout d'un employe</span>
                <f:form method="post" modelAttribute = "personne_employe" class = "s12"
                        action = "${pageContext.request.contextPath}/employe/add">
                    <div class="row">
                        <div class="input-field col s4">
                            <f:input path="personne.prenom" id="prenom" type="text" class="validate"/>
                            <label for="prenom">Prénom</label>
                        </div>
                        <div class="input-field col s4">
                            <f:input path="personne.nom" id="nom" type="text" class="validate"/>
                            <label for="nom">Nom</label>
                        </div>
                        <div class="input-field col s4">
                            <f:input path="employe.type" id="type" type="text" class="validate"/>
                            <label for="type">Type</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <f:input path="employe.login" id="login" type="text" class="validate"/>
                            <label for="login">Login</label>
                        </div>
                        <div class="input-field col s6">
                            <f:input path="employe.mot_de_passe" id="mot_de_passe" type="text" class="validate"/>
                            <label for="mot_de_passe">Mot de passe</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s4">
                            <f:input path="employe.adresse" id="adresse" type="text" class="validate"/>
                            <label for="adresse">Adresse</label>
                        </div>
                        <div class="input-field col s4">
                            <f:input path="employe.age" id="age" type="number" class="validate"/>
                            <label for="age">Age</label>
                        </div>
                        <div class="input-field col s4">
                            <f:input path="employe.salaire" id="salaire" type="text" class="validate"/>
                            <label for="salaire">Salaire</label>
                        </div>
                    </div>
                    <div class="right-align">
                        <button class="btn waves-effect waves-light" value="creer" type="submit">Créer
                                <i class="material-icons right">send</i>
                        </button>
                    </div>
                </f:form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../template/footer.jsp"%>

