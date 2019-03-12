/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Orann
 */
@Entity
@Table(name = "client")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_personne;
    private int nombre_demi_journee;   
    private float prix_paye;

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public int getNombre_demi_journee() {
        return nombre_demi_journee;
    }

    public void setNombre_demi_journee(int nombre_demi_journee) {
        this.nombre_demi_journee = nombre_demi_journee;
    }

    public float getPrix_paye() {
        return prix_paye;
    }

    public void setPrix_paye(float prix_paye) {
        this.prix_paye = prix_paye;
    }
    
    
}
