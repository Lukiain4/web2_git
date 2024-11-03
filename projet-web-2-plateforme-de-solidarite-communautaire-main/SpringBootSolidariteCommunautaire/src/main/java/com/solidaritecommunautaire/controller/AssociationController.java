package com.solidaritecommunautaire.controller;

import com.solidaritecommunautaire.entities.Association;
import com.solidaritecommunautaire.entities.IndividuSolidaire;
import com.solidaritecommunautaire.services.AssociationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Controller
public class AssociationController {
    @Autowired
    AssociationService service;
    @GetMapping("/associations")
    public String afficherAssociation (Model model){
        List<Association> listeAssociations = service.afficherAssociations();
        model.addAttribute("listeAssociations",listeAssociations);
        return "associations";
    }

    @GetMapping("/association/new")
    public String afficherFormualireAssociation(Model model){
        Association association = new Association();
        model.addAttribute("association",association);
        return "association_form";
    }

    @PostMapping("/association/save")
    public String ajouterAssociation(Association association, RedirectAttributes redirectAttributes) throws IOException {
        service.enregistrerAssociation(association);
        redirectAttributes.addFlashAttribute("message", "L'association a été ajouté avec succès.");
        return "redirect:/index";
    }


    @GetMapping("/connexion_association")
    public String afficherFormulaireConnexion(Model model){
        Association association = new Association();
        model.addAttribute("association", association);
        model.addAttribute("pageTitle","Connexion Association");
        return "connexion_association";
    }

    @PostMapping("/connexion_association/verification")
    public String verifierConnexion(Model model, RedirectAttributes redirectAttributes, @Param("email") String email, @Param("password") String password, HttpServletRequest request, HttpServletResponse response){
        Association association =  service.rechercherAssociationParEmailMotDePasse(email,password);
        if(association!=null){
            HttpSession session = request.getSession(true);
            session.setAttribute("id", association.getId());
            session.setAttribute("nom", association.getNomAssociation());


            Cookie emailCookie = new Cookie("email",email);
            Cookie mdpCookie = new Cookie("password",password);
            emailCookie.setMaxAge(Duration.ofDays(60*60).getNano());
            mdpCookie.setMaxAge(Duration.ofDays(60*60).getNano());
            response.addCookie(emailCookie);
            response.addCookie(mdpCookie);
            model.addAttribute("association", association);
            System.out.println("session : " + session.getAttribute("nom"));
            return "redirect:/index";
        }else {
            redirectAttributes.addFlashAttribute("message", "L'email ou mot de passe invalide ");
            return "redirect:/connexion_association";
        }
    }
/*
    @GetMapping("/deconnexion")
    public String deconnexion(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        Iterable<Association> listeAssociations = service.afficherAssociations();
        model.addAttribute("listeAssociations",listeAssociations);
        HttpSession session = request.getSession(false);

        if (session!=null) {
            String nom = (String) session.getAttribute("nom");
            String prenom = (String) session.getAttribute("prenom");
            session.invalidate();
            if (nom!=null) {
                redirectAttributes.addFlashAttribute("deconnexion", "Deconnexion réussie pour " + nom  + " " + prenom);

            }
        }
        return "redirect:/index";
    }
*/
}
