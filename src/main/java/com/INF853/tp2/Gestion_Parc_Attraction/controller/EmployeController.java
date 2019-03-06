/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import com.INF853.tp2.Gestion_Parc_Attraction.service.EmployeService;
import com.INF853.tp2.Gestion_Parc_Attraction.service.PersonneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        modelMap.put("size", employes.size());
        modelMap.put("employes", employes);
        modelMap.put("personnes", personneService.findAll());
        modelMap.put("title", "Accueil");
        return "employe/index"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        modelMap.put("personne", new Personne());
        return "personne/add"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personne") Personne personne){
        personneService.create(personne);
        return "redirect:/personne"; 
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String add(@PathVariable("id") int id){
        personneService.delete(id);
        return "redirect:/personne"; 
    }
    
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.put("personne", personneService.find(id));
        return "personne/edit"; 
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("personne") Personne personne){
        personneService.update(personne);
        return "redirect:/personne"; 
    }
    
}
