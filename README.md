# TP2 8INF853 - Gestion de parc d'attraction

# Installation

* Cloner le dépôt
* Dans votre IDE préféré importer un projet Maven en séléctionnant le dossier que vous avez précédemment cloné

* Grâce à Maven, votre IDE va automatiquement se configurer une fois que vous lancerez le projet.
* L'application SpringBoot/SpringMVC gestion de parc d'attraction est maintenant accessible à l’adresse http://localhost:8080

# Configuration de la base de données
* Le SGBD utilisé est MariaDB 10.1.38
* Récuéprer le script TP2.sql à la racine du projet afin d'importer la base de données dans votre sgbd.
* Récupérer le script TP2_insert.sql à la racine du projet afin de créer un utilisateur administrateur (login : admin, mdp : admin)
* Pour configurer la base de données, vous devez modifier le fichier `./src/main/resources/application.properties` afin de renseigner les paramètres de configuration lié à votre base de données

# Autres informations
Pour mener à bien notre projet, nous avons décidé d'utiliser le gestionnaire de paquet Maven nous permettant ainsi d'inclure les technologies java suivantes : <br>
* SpringBoot 2.1.3
* SpringMVC (dernière version incluse grâce à SpringBoot)
* Hibernate Core 5.3.7
* Hibernate Commons Annotations 5.0.4
* Tomcat 9.0.16 (version embarquée grâce à Maven) <br>

Nous avons également utilisé un framework HTML/CSS/JS pour notre interface graphique : Materialize.css.
