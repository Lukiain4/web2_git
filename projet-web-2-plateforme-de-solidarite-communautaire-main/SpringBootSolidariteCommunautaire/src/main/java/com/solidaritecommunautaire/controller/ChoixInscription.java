package com.solidaritecommunautaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChoixInscription {
    @GetMapping("/inscription")
    public String pageAccueilBarreNave (){
        return "inscription";
    }

}
