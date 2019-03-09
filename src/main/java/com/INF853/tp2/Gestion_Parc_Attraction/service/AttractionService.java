/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Attraction;
import java.util.List;

/**
 *
 * @author Pierre
 */
public interface AttractionService {
    public List<Attraction> findAll();
    
    public Attraction find(int id);
    
    public List<Attraction> findByName(String nom);
    
    public void create(Attraction attraction);
    
    public void update(Attraction attraction);
    
    public void delete(int id);
}
