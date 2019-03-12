/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.dao;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Orann
 */
@Repository("personneDAO")
public class PersonneDAOImpl implements PersonneDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Personne> findAll(String nom) {
        List<Personne> personnes = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            System.out.println(nom);
            personnes = session.createSQLQuery("SELECT p.id_personne, p.nom, p.prenom FROM `personne` p JOIN "+nom+" c ON p.id_personne = c.id_personne")
                    .addScalar("id_personne", new IntegerType())
                    .addScalar("nom", new StringType())
                    .addScalar("prenom", new StringType())
                    .setResultTransformer(Transformers.aliasToBean(Personne.class))
                    .list();

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
        return personnes;
    }
    
    @Override
    public Personne find(int id) {
        Personne personne = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            personne = (Personne) session.createQuery("from Personne where id_personne = :id")
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
        return personne;
    }
    
    @Override
    public List<Personne> findByPersonne(String nom) {
        List<Personne> searchpersonnes = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            //searchpersonnes = session.createQuery("from Personne where nom LIKE '%"+nom+"%' OR prenom LIKE '%"+nom+"%'").list();
            searchpersonnes = session.createSQLQuery("SELECT p.id_personne, nom, prenom FROM `personne` p JOIN employe c ON p.id_personne = c.id_personne where nom LIKE '%"+nom+"%' OR prenom LIKE '%"+nom+"%' OR login LIKE '%"+nom+"%' OR type LIKE '%"+nom+"%'")
                    .addScalar("id_personne", new IntegerType())
                    .addScalar("nom", new StringType())
                    .addScalar("prenom", new StringType())
                    .setResultTransformer(Transformers.aliasToBean(Personne.class))
                    .list();
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
        return searchpersonnes;
    }
    
    @Override
    public void create(Personne personne) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(personne);
            transaction.commit();
            /*transaction = session.beginTransaction();
            int id_personne = session.createQuery("from Personne where id_personne = :id")
                    .setInteger("id", id)
                    .uniqueResult();
            transaction.commit();*/
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
    public void update(Personne personne) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(personne);
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