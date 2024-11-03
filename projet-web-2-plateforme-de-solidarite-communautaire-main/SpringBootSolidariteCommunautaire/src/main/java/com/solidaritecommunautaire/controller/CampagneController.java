package com.solidaritecommunautaire.controller;

import com.solidaritecommunautaire.entities.Campagne;
import com.solidaritecommunautaire.entities.Ressources;
import com.solidaritecommunautaire.repos.CampagneRepository;
import com.solidaritecommunautaire.services.CampagneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;
import java.util.List;

@Controller
public class CampagneController {
    @Autowired
    CampagneService service;

    @GetMapping("/campagnes")
    public String afficherCampagne (Model model){
        Iterable<Campagne> listeCampagnes = service.afficherCampagne();
        model.addAttribute("listeCampagnes",listeCampagnes);
        return "campagnes";
    }

    @GetMapping("/campagne/new")
    public String afficherFormualaireCampagne(Model model){
        Campagne campagne = new Campagne();
        model.addAttribute("campagne",campagne);
        return "campagne_form";
    }

    @PostMapping("/campagne/save")
    public String ajouterCampagne(Campagne campagne, RedirectAttributes redirectAttributes) throws IOException {
        redirectAttributes.addFlashAttribute("message", "La campagne a été ajouté avec succès.");
        service.enregistrerCampagne(campagne);
        return "redirect:/campagnes";
    }

}
