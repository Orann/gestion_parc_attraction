/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import java.util.List;

/**
 *
 * @author Orann
 */
public interface EmployeService {
    public List<Employe> findAll();
    
    public Employe find(int id);
    
    public Employe find(String login);
    
    public List<Employe> findByEmploye(String nom);
    
    public void create(Personne personne, Employe employe);
    
    public void update(Employe employe);
    
    public void delete(int id);
}
