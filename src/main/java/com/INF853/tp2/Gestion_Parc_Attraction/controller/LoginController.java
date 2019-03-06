/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.INF853.tp2.Gestion_Parc_Attraction.controller;

import com.INF853.tp2.Gestion_Parc_Attraction.model.Employe;
import com.INF853.tp2.Gestion_Parc_Attraction.model.Personne;
import com.INF853.tp2.Gestion_Parc_Attraction.service.EmployeService;
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
@RequestMapping("login")
public class LoginController {

    @Autowired
    private EmployeService employeService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("title", "Connexion");
        modelMap.put("employe", new Employe());
        return "login/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute("employe") Employe employe, ModelMap modelMap) {
        String retour = "redirect:/login";
        Employe employe_to_check = employeService.find(employe.getLogin());
        System.out.println(employe.getLogin());
        if (employe_to_check != null) {
            if (employe_to_check.getMot_de_passe().equals(employe.getMot_de_passe())) {
                retour = "redirect:/employe";
            } else {
                retour = "login/index";
            }
        } else {
            retour = "login/index";
        }

        return retour;
    }

}
