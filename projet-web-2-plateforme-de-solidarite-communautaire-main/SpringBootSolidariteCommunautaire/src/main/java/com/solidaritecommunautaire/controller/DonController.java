package com.solidaritecommunautaire.controller;

import com.solidaritecommunautaire.entities.Dons;
import com.solidaritecommunautaire.entities.IndividuSolidaire;
import com.solidaritecommunautaire.entities.InitiativeCaritative;
import com.solidaritecommunautaire.entities.Role;
import com.solidaritecommunautaire.services.DonService;
import com.solidaritecommunautaire.services.IndividuNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class DonController {
    @Autowired
    DonService service;

    @GetMapping("/don")
    public String afficherDons (Model model) {

            List<Dons> listeDons = service.afficherDons();
            model.addAttribute("listDons",listeDons);

        return "individu";
    }

    @GetMapping("/don/new")
    public String afficherFormualireDon(Model model){

        Dons don = new Dons();
        model.addAttribute("don",don);

        return "dons_form";
    }

    @PostMapping("/don/save")
    public String ajouterDon(Dons don, RedirectAttributes redirectAttributes){

            service.enregistrerDons(don);

            redirectAttributes.addFlashAttribute("message", "Le don a été ajouté avec succès.");
        return "redirect:/index";
    }

}
