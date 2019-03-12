/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.dao;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import java.util.List;

/**
 *
 * @author Orann
 */
public interface PersonneDAO {
    public List<Personne> findAll(String nom);
    
    public Personne find(int id);
    
    public void create(Personne personne);
    
    public void update(Personne personne);
    
    public void delete(int id);
}
