/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.dao.PersonneDAO;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Orann
 */
@Service
@Repository("personneService")
public class PersonneServiceImpl implements PersonneService {
    
    @Autowired
    private PersonneDAO personneDAO;

    @Override
    public List<Personne> findAll() {
        return this.personneDAO.findAll();
    }

    @Override
    public Personne find(int id) {
        return this.personneDAO.find(id);
    }

    @Override
    public void create(Personne personne) {
        this.personneDAO.create(personne);
    }

    @Override
    public void update(Personne personne) {
        this.personneDAO.update(personne);    
    }

    @Override
    public void delete(int id) {
        this.personneDAO.delete(id);
    }
    
}
