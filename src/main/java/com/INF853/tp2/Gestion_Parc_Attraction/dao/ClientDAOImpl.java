/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.dao;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Client;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Orann
 */
@Repository("clientDAO")
public class ClientDAOImpl implements ClientDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Client> findAll() {
        List<Client> clients = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            clients = session.createQuery("from Client").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }            
        }
        return clients;
    }
    
    @Override
    public Client find(int id) {
        Client client = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            client = (Client) session.createQuery("from Client where id_personne = :id")
                    .setInteger("id", id)
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }            
        }
        return client;
    }
    
    @Override
    public void create(Personne personne, Client client) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(personne);
            /*session.createSQLQuery("INSERT INTO `personne` (`id_personne`, `nom`, `prenom`) "
                    + "VALUES (NULL, :nom, :prenom);")
                    .setString("nom", personne.getNom())
                    .setString("prenom", personne.getPrenom())
                    .uniqueResult();*/        
            transaction.commit();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            int id_personne = (int) session.createSQLQuery("SELECT MAX(id_personne) from personne")
                    .uniqueResult();
            transaction.commit();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            client.setId_personne(id_personne);
            session.createSQLQuery("INSERT INTO `client` (`id_personne`, `nombre_demi_journee`, `prix_paye`)"
                    + " VALUES (:id, :nombre_demi_journee, :prix_paye)")
                    .setInteger("id", client.getId_personne())
                    .setInteger("nombre_demi_journee", client.getNombre_demi_journee())
                    .setFloat("prix_paye", client.getPrix_paye())
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }            
        }
    }
    
    @Override
    public void update(Client client) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }            
        }
    }
    
    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(this.find(id));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }            
        }
    }
    
}
