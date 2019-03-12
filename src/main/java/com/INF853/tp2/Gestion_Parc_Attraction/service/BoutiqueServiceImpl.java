/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.dao.BoutiqueDAO;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Boutique;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pierre
 */
@Service
@Repository("boutiqueService")
public class BoutiqueServiceImpl implements BoutiqueService {
    
    @Autowired
    private BoutiqueDAO boutiqueDAO;

    @Override
    public List<Boutique> findAll() {
        return this.boutiqueDAO.findAll();
    }

    @Override
    public Boutique find(int id) {
        return this.boutiqueDAO.find(id);
    }

    @Override
    public void create(Boutique boutique) {
        this.boutiqueDAO.create(boutique);
    }

    @Override
    public void update(Boutique boutique) {
        this.boutiqueDAO.update(boutique);    
    }

    @Override
    public void delete(int id) {
        this.boutiqueDAO.delete(id);
    }
    
}
