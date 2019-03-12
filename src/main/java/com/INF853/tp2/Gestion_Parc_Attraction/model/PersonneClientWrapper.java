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
public class PersonneClientWrapper {
    private Personne personne;
    private Client client;

    public PersonneClientWrapper() {
        personne = new Personne();
        client = new Client();
    }    

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
