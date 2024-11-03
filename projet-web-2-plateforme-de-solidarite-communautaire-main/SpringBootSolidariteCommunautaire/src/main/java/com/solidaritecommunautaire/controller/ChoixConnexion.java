package com.solidaritecommunautaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChoixConnexion {
    @GetMapping("/connexion")
    public String pageAccueilBarreNave (){
        return "connexion";
    }
}
