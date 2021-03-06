/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.dao;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Orann
 */
@Repository("employeDAO")
public class EmployeDAOImpl implements EmployeDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Employe> findAll() {
        List<Employe> employes = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            employes = session.createQuery("from Employe").list();
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
        return employes;
    }
    
    @Override
    public Employe find(int id) {
        Employe employe = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            employe = (Employe) session.createQuery("from Employe where id_personne = :id")
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
        return employe;
    }
    
    @Override
    public Employe find(String login) {
        Employe employe = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            employe = (Employe) session.createQuery("from Employe where login = :login")
                    .setString("login", login)
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
        return employe;
    }
    
    @Override
    public List<Employe> findByEmploye(String nom) {
        List<Employe> searchemployes = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            //searchemployes = session.createQuery("from Employe where login LIKE '%"+nom+"%' OR type LIKE '%"+nom+"%'").list();
            searchemployes = session.createSQLQuery("SELECT c.id_personne, login, type, adresse, age, salaire FROM `personne` p JOIN employe c ON p.id_personne = c.id_personne where nom LIKE '%"+nom+"%' OR prenom LIKE '%"+nom+"%' OR login LIKE '%"+nom+"%' OR type LIKE '%"+nom+"%'")
                    .addScalar("id_personne", new IntegerType())
                    .addScalar("login", new StringType())
                    .addScalar("type", new StringType())
                    .addScalar("age", new IntegerType())
                    .addScalar("adresse", new StringType())
                    .addScalar("salaire", new FloatType())
                    .setResultTransformer(Transformers.aliasToBean(Employe.class))
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
        return searchemployes;
    }
    
    @Override
    public void create(Personne personne, Employe employe) {
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
            employe.setId_personne(id_personne);
            session.createSQLQuery("INSERT INTO `employe` (`id_personne`, `login`, `mot_de_passe`, `type`, adresse, age, salaire)"
                    + " VALUES (:id, :login, :mot_de_passe, :type, :adresse, :age, :salaire)")
                    .setInteger("id", employe.getId_personne())
                    .setString("login", employe.getLogin())
                    .setString("mot_de_passe", employe.getMot_de_passe())
                    .setString("type", employe.getType())
                    .setString("adresse", employe.getAdresse())
                    .setInteger("age", employe.getAge())
                    .setFloat("salaire", employe.getSalaire())
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
    public void update(Employe employe) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(employe);
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
