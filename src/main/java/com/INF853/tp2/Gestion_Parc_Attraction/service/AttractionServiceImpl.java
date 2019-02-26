/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.dao.AttractionDAO;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Attraction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pierre
 */
@Service
@Repository("attractionService")
public class AttractionServiceImpl implements AttractionService {
    
    @Autowired
    private AttractionDAO attractionDAO;

    @Override
    public List<Attraction> findAll() {
        return this.attractionDAO.findAll();
    }

    @Override
    public Attraction find(int id) {
        return this.attractionDAO.find(id);
    }

    @Override
    public void create(Attraction attraction) {
        this.attractionDAO.create(attraction);
    }

    @Override
    public void update(Attraction attraction) {
        this.attractionDAO.update(attraction);    
    }

    @Override
    public void delete(int id) {
        this.attractionDAO.delete(id);
    }
    
}
