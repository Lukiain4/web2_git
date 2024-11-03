package com.solidaritecommunautaire.controller;

import com.solidaritecommunautaire.entities.InitiativeCaritative;
import com.solidaritecommunautaire.entities.Projet;
import com.solidaritecommunautaire.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjetController {
    @Autowired
    ProjetService service;

    @GetMapping("/projets")
    public String pageProjets (Model model){
        List<Projet> listeProjets = service.afficherProjets();
        model.addAttribute("listProjets", listeProjets);

        List<InitiativeCaritative> listeInitiatives = service.afficherInitiatives();
        model.addAttribute("listInitiatives", listeInitiatives);

        return "projets";
    }
}
