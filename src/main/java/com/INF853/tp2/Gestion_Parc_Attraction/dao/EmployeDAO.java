/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.dao;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import java.util.List;

/**
 *
 * @author Orann
 */
public interface EmployeDAO {
    public List<Employe> findAll();
    
    public Employe find(int id);
    
    public Employe find(String login);
    
    public void create(Employe employe);
    
    public void update(Employe employe);
    
    public void delete(int id);
}
