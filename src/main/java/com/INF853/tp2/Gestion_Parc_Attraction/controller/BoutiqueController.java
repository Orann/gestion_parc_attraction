/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Boutique;
import com.INF853.tp2.Gestion_Parc_Attraction.service.BoutiqueService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("boutique")
public class BoutiqueController {
    @Autowired
    private BoutiqueService boutiqueService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_des_boutiques") || cookies[2].getValue().equals("Administrateur")) {
                modelMap.put("boutiques", boutiqueService.findAll());
                modelMap.put("title", "Accueil");
                return "boutique/index";
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_des_boutiques") || cookies[2].getValue().equals("Administrateur")) {
                modelMap.addAttribute("boutique", new Boutique());
                modelMap.put("boutique", new Boutique());
                Map<String, String> types = new HashMap<String, String>();
                types.put("Restaurant", "Restaurant");
                types.put("Souvenir", "Souvenir");
                types.put("Food Truck", "Food Truck");
                modelMap.put("type", types);
                return "boutique/add";
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("boutique") Boutique boutique){
        boutiqueService.create(boutique);
        return "redirect:/boutique"; 
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String add(@PathVariable("id") int id, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_des_boutiques") || cookies[2].getValue().equals("Administrateur")) {
                boutiqueService.delete(id);
                return "redirect:/boutique"; 
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_des_boutiques") || cookies[2].getValue().equals("Administrateur")) {
                modelMap.addAttribute("boutique", new Boutique());
                modelMap.put("boutique", boutiqueService.find(id));
                Map<String, String> types = new HashMap<String, String>();
                types.put("Restaurant", "Restaurant");
                types.put("Souvenir", "Souvenir");
                types.put("Food Truck", "Food Truck");
                modelMap.put("type", types);
                return "boutique/edit";
            }
        }
        return "redirect:/login";
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("boutique") Boutique boutique){
        boutiqueService.update(boutique);
        return "redirect:/boutique"; 
    }
}
