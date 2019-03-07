/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.model;

/**
 *
 * @author Orann
 */
public class PersonneEmployeWrapper {
    private Personne personne;
    private Employe employe;

    public PersonneEmployeWrapper() {
        personne = new Personne();
        employe = new Employe();
    }
    
    

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
