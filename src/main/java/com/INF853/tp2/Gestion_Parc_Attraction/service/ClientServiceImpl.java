/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.service;

import com.INF853.tp2.Gestion_Parc_Attraction.dao.ClientDAO;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Client;
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
@Repository("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public List<Client> findAll() {
        return this.clientDAO.findAll();
    }

    @Override
    public Client find(int id) {
        return this.clientDAO.find(id);
    }

    @Override
    public void create(Personne personne, Client client) {
        this.clientDAO.create(personne, client);
    }

    @Override
    public void update(Client client) {
        this.clientDAO.update(client);    
    }

    @Override
    public void delete(int id) {
        this.clientDAO.delete(id);
    }
    
}
