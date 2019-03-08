/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.dao;

//import com.INF853.tp2.Gestion_Parc_Attraction.model.Attraction;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Boutique;
import java.util.List;

/**
 *
 * @author Pierre
 */
public interface BoutiqueDAO {
    public List<Boutique> findAll();
    
    public Boutique find(int id);
    
    public void create(Boutique boutique);
    
    public void update(Boutique boutique);
    
    public void delete(int id);
}
