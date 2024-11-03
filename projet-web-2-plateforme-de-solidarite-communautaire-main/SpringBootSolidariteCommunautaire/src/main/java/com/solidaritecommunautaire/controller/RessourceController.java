package com.solidaritecommunautaire.controller;

import com.solidaritecommunautaire.entities.Dons;
import com.solidaritecommunautaire.entities.InitiativeCaritative;
import com.solidaritecommunautaire.entities.Ressources;
import com.solidaritecommunautaire.entities.Role;
import com.solidaritecommunautaire.services.RessourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class RessourceController {
    @Autowired
    RessourceService service;

    @GetMapping("/ressources")
    public String afficherRessources (Model model){
        List<Ressources> listeRessources = service.afficherRessources();
        model.addAttribute("listRessources",listeRessources);

        return "ressources";
    }

    @GetMapping("/ressource/new")
    public String afficherFormualireRessource(Model model){
        Ressources ressources = new Ressources();
        model.addAttribute("ressources",ressources);
        return "ressources_form";
    }

    @PostMapping("/ressource/save")
    public String ajouterRessource(Ressources ressources, RedirectAttributes redirectAttributes) throws IOException {
        redirectAttributes.addFlashAttribute("message", "La ressource a été ajouté avec succès.");
        service.enregistrerRessources(ressources);
        return "redirect:/ressources";
    }

}
