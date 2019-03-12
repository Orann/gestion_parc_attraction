/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Pierre
 */
@Controller
@RequestMapping("")
public class MenuController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 1) {
            if(cookies[2].getValue().equals("Gerant_du_personnel") || cookies[2].getValue().equals("Gerant_des_attractions") 
                    || cookies[2].getValue().equals("Gerant_des_boutiques") || cookies[2].getValue().equals("Administrateur")){
                 modelMap.put("cookieLogin", cookies[1].getValue());
                 modelMap.put("cookieType", cookies[2].getValue());
                 modelMap.put("title", "Accueil");        
                return "welcome/index"; 
            }
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = "deconnexion", method = RequestMethod.GET)
    public String deconnexion(){
        return  "redirect:/"; 
    }
}
