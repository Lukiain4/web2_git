package com.solidaritecommunautaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("")
    public String pageAccueil (){
        return "index";
    }

    @GetMapping("/index")
    public String pageAccueilBarreNave (){
        return "index";
    }

}
