/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Attraction;
import com.INF853.tp2.Gestion_Parc_Attraction.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        modelMap.put("title", "Accueil");
        return "attraction/index"; 
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){
        modelMap.addAttribute("attraction", new Attraction());
        modelMap.put("attraction", new Attraction());
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
        return "attraction/edit"; 
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("attraction") Attraction attraction){
        attractionService.update(attraction);
        return "redirect:/attracion"; 
    }
}