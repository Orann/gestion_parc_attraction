/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import com.INF853.tp2.Gestion_Parc_Attraction.model.PersonneEmployeWrapper;
import com.INF853.tp2.Gestion_Parc_Attraction.service.EmployeService;
import com.INF853.tp2.Gestion_Parc_Attraction.service.PersonneService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronizationUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Orann
 */
@Controller
@RequestMapping("employe")
public class EmployeController {
    @Autowired
    private PersonneService personneService;
    
    @Autowired
    private EmployeService employeService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        List<Employe> employes = employeService.findAll();
        List<Personne> personnes = personneService.findAll("employe");
        for(Employe e : employes){
            System.out.println(e.getLogin());
        }
        for(Personne p : personnes){
            System.out.println(p.getNom());
        }
        
        modelMap.put("size", employes.size());
        System.out.println(employes.size());
        modelMap.put("employes", employes);
        modelMap.put("personnes", personnes);
        modelMap.put("title", "Gestion Employe");
        return "employe/index"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        PersonneEmployeWrapper pew = new PersonneEmployeWrapper();
        modelMap.put("personne_employe", pew);
        return "employe/add"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personne_employe") PersonneEmployeWrapper pew){
        employeService.create(pew.getPersonne(), pew.getEmploye());
        return "redirect:/employe"; 
    }
    
    @RequestMapping(value = "delete/{id_personne}", method = RequestMethod.GET)
    public String delete(@PathVariable("id_personne") int id_personne){
        employeService.delete(id_personne);
        personneService.delete(id_personne);        
        return "redirect:/employe"; 
    }
    
    @RequestMapping(value = "edit/{id_personne}", method = RequestMethod.GET)
    public String edit(@PathVariable("id_personne") int id_personne, ModelMap modelMap){
        PersonneEmployeWrapper pew = new PersonneEmployeWrapper();
        pew.setPersonne(personneService.find(id_personne));
        pew.setEmploye(employeService.find(id_personne));
        modelMap.put("personne_employe", pew);
        return "employe/edit"; 
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("personne_employe") PersonneEmployeWrapper pew){
        personneService.update(pew.getPersonne());
        
        employeService.update(pew.getEmploye());
        return "redirect:/employe"; 
    }
    
    @RequestMapping(value = "details/{id_personne}", method = RequestMethod.GET)
    public String details(@PathVariable("id_personne") int id_personne, ModelMap modelMap){
        PersonneEmployeWrapper pew = new PersonneEmployeWrapper();
        pew.setPersonne(personneService.find(id_personne));
        pew.setEmploye(employeService.find(id_personne));
        modelMap.put("personne_employe", pew);
        return "employe/details"; 
    }
}
