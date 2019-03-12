/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Client;
import com.INF853.tp2.Gestion_Parc_Attraction.model.PersonneClientWrapper;

import com.INF853.tp2.Gestion_Parc_Attraction.service.ClientService;
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
@RequestMapping("client")
public class ClientController {
    @Autowired
    private PersonneService personneService;
    
    @Autowired
    private ClientService clientService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        List<Client> clients = clientService.findAll();
        modelMap.put("size", clients.size());
        modelMap.put("clients", clients);
        modelMap.put("personnes", personneService.findAll("client"));
        modelMap.put("title", "Gestion client");
        return "client/index"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        PersonneClientWrapper pcw = new PersonneClientWrapper();
        modelMap.put("personne_client", pcw);
        return "client/add"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personne_client") PersonneClientWrapper pcw){
        clientService.create(pcw.getPersonne(), pcw.getClient());
        return "redirect:/client"; 
    }
    
    @RequestMapping(value = "delete/{id_personne}", method = RequestMethod.GET)
    public String delete(@PathVariable("id_personne") int id_personne){
        clientService.delete(id_personne);
        personneService.delete(id_personne);        
        return "redirect:/client"; 
    }
    
    @RequestMapping(value = "edit/{id_personne}", method = RequestMethod.GET)
    public String edit(@PathVariable("id_personne") int id_personne, ModelMap modelMap){
        PersonneClientWrapper pcw = new PersonneClientWrapper();
        pcw.setPersonne(personneService.find(id_personne));
        pcw.setClient(clientService.find(id_personne));
        modelMap.put("personne_client", pcw);
        return "client/edit"; 
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("personne_client") PersonneClientWrapper pcw){
        personneService.update(pcw.getPersonne());
        clientService.update(pcw.getClient());
        return "redirect:/client"; 
    }
}
