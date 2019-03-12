/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import java.util.List;

/**
 *
 * @author Orann
 */
public interface PersonneService {
    public List<Personne> findAll(String nom);
    
    public Personne find(int id);
    
    public List<Personne> findByPersonne(String nom);
    
    public void create(Personne personne);
    
    public void update(Personne personne);
    
    public void delete(int id);
}
