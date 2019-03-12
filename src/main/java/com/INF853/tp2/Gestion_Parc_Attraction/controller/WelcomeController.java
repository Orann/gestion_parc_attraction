/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import java.util.Arrays;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Orann
 */
@Controller
@RequestMapping("")
public class WelcomeController {
    @RequestMapping(method = RequestMethod.GET)
    
    public String index(ModelMap modelMap){
        modelMap.put("title", "Accueil");        
        return "welcome/index"; 
    }
    
    @RequestMapping(value = "deconnexion", method = RequestMethod.GET)
    public String deconnexion(){
        return  "redirect:/"; 
    }
}
