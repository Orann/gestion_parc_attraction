/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orann
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private EmployeService employeService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpServletResponse response) {
        modelMap.put("title", "Connexion");
        modelMap.put("employe", new Employe());
        Cookie cookieLogin = new Cookie("cookieLogin", "");
        cookieLogin.setMaxAge(0);
        cookieLogin.setPath("/");
        response.addCookie(cookieLogin);
        Cookie cookieType = new Cookie("cookieType", "");
        cookieType.setMaxAge(0);
        cookieType.setPath("/");
        response.addCookie(cookieType);
        return "login/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute("employe") Employe employe, ModelMap modelMap, HttpServletResponse response) {
        String retour = "redirect:/login";
        Employe employe_to_check = employeService.find(employe.getLogin());
        if (employe_to_check != null) {
            if (employe_to_check.getMot_de_passe().equals(employe.getMot_de_passe())) {
                Cookie cookieLogin = new Cookie("cookieLogin", employe_to_check.getLogin());
                cookieLogin.setMaxAge(24 * 60 * 60);
                cookieLogin.setPath("/");
                response.addCookie(cookieLogin);
                Cookie cookieType = new Cookie("cookieType", employe_to_check.getType());
                cookieType.setMaxAge(24 * 60 * 60);
                cookieType.setPath("/");
                response.addCookie(cookieType);
                retour = "redirect:/employe";
            } else {
                modelMap.put("erreur", "Login ou mot de passe incorect.");
                retour = "login/index";
            }
        } else {
            modelMap.put("erreur", "Login ou mot de passe incorect.");
            retour = "login/index";
        }
        return retour;
    }

}
