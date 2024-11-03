package com.solidaritecommunautaire.controller;

import com.solidaritecommunautaire.entities.IndividuSolidaire;
import com.solidaritecommunautaire.entities.InitiativeCaritative;
import com.solidaritecommunautaire.entities.Projet;
import com.solidaritecommunautaire.entities.Role;
import com.solidaritecommunautaire.services.IndividuService;
import com.solidaritecommunautaire.services.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class InitiativeController {
    @Autowired
    InitiativeService service;

    @GetMapping("/initiative")
    public String afficherInitiatives (Model model){
        List<InitiativeCaritative> listeInitiatives = service.afficherInitiatives();
        model.addAttribute("listInitiatives",listeInitiatives);

        return "projets";
    }

    @GetMapping("/initiative/new")
    public String afficherFormualireInitiative(Model model){
        List<Role>  listRoles = service.afficherRoles();

        model.addAttribute("listRoles",listRoles);

        InitiativeCaritative initiative = new InitiativeCaritative();
        model.addAttribute("initiative",initiative);
        return "initiative_form";
    }

    @PostMapping("/initiative/save")
    public String ajouterInitiative(InitiativeCaritative initiative, RedirectAttributes redirectAttributes) throws IOException{
        redirectAttributes.addFlashAttribute("message", "L'initiative a été ajouté avec succès.");
        service.enregistrerInitiative(initiative);
        return "redirect:/projets";
    }
}
