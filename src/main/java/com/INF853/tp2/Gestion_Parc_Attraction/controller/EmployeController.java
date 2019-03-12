/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.model.PersonneEmployeWrapper;
import com.INF853.tp2.Gestion_Parc_Attraction.service.EmployeService;
import com.INF853.tp2.Gestion_Parc_Attraction.service.PersonneService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

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
    public String index(ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_du_personnel") || cookies[2].getValue().equals("Administrateur")) {
                List<Employe> employes = employeService.findAll();
                modelMap.put("size", employes.size());
                modelMap.put("employes", employes);
                modelMap.put("personnes", personneService.findAll());
                modelMap.put("title", "Accueil");
                return "employe/index";
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_du_personnel") || cookies[2].getValue().equals("Administrateur")) {
                PersonneEmployeWrapper pew = new PersonneEmployeWrapper();
                modelMap.put("personne_employe", pew);
                Map<String, String> types = new HashMap<String, String>();
                types.put("Gerant_des_attractions", "Gerant des attractions");
                types.put("Gerant_des_boutiques", "Gerant des boutiques");
                types.put("Gerant_du_personnel", "Gerant du personnel");
                types.put("Administrateur", "Administrateur");
                modelMap.put("type", types);
                return "employe/add"; 
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personne_employe") PersonneEmployeWrapper pew){
        employeService.create(pew.getPersonne(), pew.getEmploye());
        return "redirect:/employe"; 
    }
    
    @RequestMapping(value = "delete/{id_personne}", method = RequestMethod.GET)
    public String delete(@PathVariable("id_personne") int id_personne, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_du_personnel") || cookies[2].getValue().equals("Administrateur")) {
                employeService.delete(id_personne);
                personneService.delete(id_personne);        
                return "redirect:/employe";
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "edit/{id_personne}", method = RequestMethod.GET)
    public String edit(@PathVariable("id_personne") int id_personne, ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_du_personnel") || cookies[2].getValue().equals("Administrateur")) {
                PersonneEmployeWrapper pew = new PersonneEmployeWrapper();
                pew.setPersonne(personneService.find(id_personne));
                pew.setEmploye(employeService.find(id_personne));
                modelMap.put("personne_employe", pew);
                Map<String, String> types = new HashMap<String, String>();
                types.put("Gerant_des_attractions", "Gerant des attractions");
                types.put("Gerant_des_boutiques", "Gerant des boutiques");
                types.put("Gerant_du_personnel", "Gerant du personnel");
                types.put("Administrateur", "Administrateur");
                modelMap.put("type", types);
                return "employe/edit";
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("personne_employe") PersonneEmployeWrapper pew){
        personneService.update(pew.getPersonne());
        employeService.update(pew.getEmploye());
        return "redirect:/employe"; 
    }
    
}
