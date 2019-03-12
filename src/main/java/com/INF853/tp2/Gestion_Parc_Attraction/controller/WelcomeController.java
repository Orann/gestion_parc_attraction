/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import javax.servlet.http.Cookie;
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
    public String index(ModelMap modelMap, HttpServletResponse response){
        modelMap.put("title", "Accueil");
        Cookie cookieLogin = new Cookie("cookieLogin", "");
        cookieLogin.setMaxAge(0);
        cookieLogin.setPath("/");
        response.addCookie(cookieLogin);
        Cookie cookieType = new Cookie("cookieType", "");
        cookieType.setMaxAge(0);
        cookieType.setPath("/");
        response.addCookie(cookieType);
        return "welcome/index"; 
    }
    
    @RequestMapping(value = "deconnexion", method = RequestMethod.GET)
    public String deconnexion(){
        return  "redirect:/"; 
    }
}
