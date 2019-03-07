/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.dao.EmployeDAO;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
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
@Repository("employeService")
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeDAO employeDAO;

    @Override
    public List<Employe> findAll() {
        return this.employeDAO.findAll();
    }

    @Override
    public Employe find(int id) {
        return this.employeDAO.find(id);
    }
    
    @Override
    public Employe find(String login) {
        return this.employeDAO.find(login);
    }

    @Override
    public void create(Personne personne, Employe employe) {
        this.employeDAO.create(personne, employe);
    }

    @Override
    public void update(Employe employe) {
        this.employeDAO.update(employe);    
    }

    @Override
    public void delete(int id) {
        this.employeDAO.delete(id);
    }
    
}
