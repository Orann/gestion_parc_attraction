/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Attraction;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Search;
import com.INF853.tp2.Gestion_Parc_Attraction.service.AttractionService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pierre
 */
@Controller
@RequestMapping("attraction")
public class AttractionController {
    @Autowired
    private AttractionService attractionService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("attractions", attractionService.findAll());
        modelMap.put("recherche", new Search());
        modelMap.put("title", "Accueil");
        return "attraction/index"; 
    }
    
    @RequestMapping(value = "search", method = RequestMethod.GET, params="nom")
    public String search(@RequestParam("nom") String recherche, ModelMap modelMap){
        modelMap.put("searchattractions", attractionService.findByName(recherche));
        modelMap.put("nom", recherche);
        return "attraction/search"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        modelMap.addAttribute("attraction", new Attraction());
        modelMap.put("attraction", new Attraction());
        Map<String, String> types = new HashMap<String, String>();
        types.put("Forte", "Forte");
        types.put("Calme", "Calme");
        types.put("Montagne russe", "Montagne russe");
        modelMap.put("type", types);
        return "attraction/add"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("attraction") Attraction attraction){
        attractionService.create(attraction);
        return "redirect:/attraction"; 
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String add(@PathVariable("id") int id){
        attractionService.delete(id);
        return "redirect:/attraction"; 
    }
    
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("attraction", new Attraction());
        modelMap.put("attraction", attractionService.find(id));
        Map<String, String> types = new HashMap<String, String>();
        types.put("Forte", "Forte");
        types.put("Calme", "Calme");
        types.put("Montagne russe", "Montagne russe");
        modelMap.put("type", types);
        return "attraction/edit"; 
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("attraction") Attraction attraction){
        attractionService.update(attraction);
        return "redirect:/attraction"; 
    }
}
