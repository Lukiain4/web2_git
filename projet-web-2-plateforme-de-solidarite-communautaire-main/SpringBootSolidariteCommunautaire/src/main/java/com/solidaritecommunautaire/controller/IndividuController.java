package com.solidaritecommunautaire.controller;

import com.solidaritecommunautaire.entities.*;
import com.solidaritecommunautaire.services.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

@Controller
public class IndividuController {
    @Autowired
    IndividuService service;

    @GetMapping("/individu/{id}")
    public String afficherIndividus(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) throws IndividuNotFoundException {
        try {
            IndividuSolidaire individu = service.trouverIndividu(id);
            model.addAttribute("individu", individu);

            List<IndividuSolidaire> listeIndividus = service.afficherIndividus();
            model.addAttribute("listIndividus", listeIndividus);

            List<Projet> listeProjets = service.afficherProjets();
            model.addAttribute("listProjets", listeProjets);

            List<Projet> projets = service.trouverProjetsIndividu(id);
            model.addAttribute("listMesProjets",projets);

            List<Dons> dons = service.trouverDonsIndividu(id);
            model.addAttribute("listMesDons",dons);

            List<Ressources> ressources = service.trouverRessourcesIndividu(id);
            model.addAttribute("listMesRessources",ressources);

            List<InitiativeCaritative> initiatives = service.trouverInitiativesIndividu(id);
            model.addAttribute("listMesInitiatives",initiatives);

        } catch (IndividuNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", "L'individu Id " + id + "n'a pas été trouvé");
        }

        return "individu";
    }

    @GetMapping("/individu/new")
    public String afficherFormualireIndividu(Model model){

        List<Role>  listRoles = service.afficherRoles();
        model.addAttribute("listRoles",listRoles);

        IndividuSolidaire individu = new IndividuSolidaire();
        model.addAttribute("individu",individu);

        return "individu_form";
    }

    @PostMapping("/individu/save")
    public String ajouterIndividu(IndividuSolidaire individu, AdministrateurPlateforme admin, OrganisateurProjetSolidaire organisateur, RedirectAttributes redirectAttributes) throws IOException{
        service.enregistrerIndividu(individu);
        redirectAttributes.addFlashAttribute("message", "L'individu a été ajouté avec succès.");
        if(individu.getRole().getId()==1){
            service.enregistrerOrganisateur(organisateur);
            service.enregistrerAdministrateur(admin);
            redirectAttributes.addFlashAttribute("message", "L'administrateur a été ajouté avec succès.");
        }else if(individu.getRole().getId()==2){
            service.enregistrerOrganisateur(organisateur);
            redirectAttributes.addFlashAttribute("message", "L'organisateur a été ajouté avec succès.");
        }
        return "redirect:/index";
    }

    @GetMapping("/individu/{id}/addProjet/{projetId}")
    public String ajouterProjetIndividu(@PathVariable(name = "id") Integer id, @PathVariable(name = "projetId") Integer projetId, Model model, RedirectAttributes redirectAttributes) {
        try {
            IndividuSolidaire individu = service.trouverIndividu(id);
            Projet unprojet = service.trouverProjet(projetId);
            individu.getProjets().add(unprojet);
            service.enregistrerIndividu(individu);
            redirectAttributes.addFlashAttribute("message",
                    "Le projet ID " + projetId + " a été ajouté avec succès à l'individu " + id);
        } catch (IndividuNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", "L'individu ID " + id + "n'a pas été trouvé");
        } catch (ProjetNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "Le projet ID " + projetId + "n'a pas été trouvé");
        }
        System.out.println("Ajout");
        return "redirect:/individu/{id}";
    }

    @GetMapping("/individu/{id}/deleteProjet/{projetId}")
    public String supprimerProjetIndividu(@PathVariable(name = "id") Integer id, @PathVariable(name = "projetId") Integer projetId, Model model, RedirectAttributes redirectAttributes) {
        try {
            IndividuSolidaire individu = service.trouverIndividu(id);
            Projet unprojet = service.trouverProjet(projetId);
            individu.getProjets().remove(unprojet);
            service.enregistrerIndividu(individu);
            redirectAttributes.addFlashAttribute("message",
                    "Le projet ID " + projetId + " a été supprimé avec succès à l'individu " + id);
        } catch (IndividuNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", "L'individu ID " + id + "n'a pas été trouvé");
        } catch (ProjetNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "Le projet ID " + projetId + "n'a pas été trouvé");
        }
        System.out.println("Suppression");
        return "redirect:/individu/{id}";
    }

    @GetMapping("/individu/{id}/editInitiative/{initiativeId}")
    public String mettreAjourInitiative(@PathVariable(name ="id" ) Integer id,@PathVariable(name ="initiativeId" ) Integer initiativeId, RedirectAttributes redirectAttributes, Model model){
        try {
            IndividuSolidaire individu = service.trouverIndividu(id);
            InitiativeCaritative uneinitiative = service.trouverInitiative(initiativeId);

            model.addAttribute("individu",individu);
            model.addAttribute("uneinitiative",uneinitiative);
            model.addAttribute("pageTitle","Editer Ressource(ID : " + id + ")" );
            return "initiative_form";

        }catch (IndividuNotFoundException ex){
            redirectAttributes.addFlashAttribute("message","L'individu avec ID " +id + " est introuvable ");
        } catch (InitiativeNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "L'initiative ID " + initiativeId + "n'a pas été trouvé");
        }

        return "redirect:/individu/{id}";
    }

    @GetMapping("/individu/{id}/deleteInitiative/{initiativeId}")
    public String supprimerInitiativeIndividu(@PathVariable(name = "id") Integer id, @PathVariable(name = "initiativeId") Integer initiativeId, Model model, RedirectAttributes redirectAttributes) {
        try {

            service.supprimerInitiativeIndividu(initiativeId);
            redirectAttributes.addFlashAttribute("message",
                    "L'initiative ID " + initiativeId + " a été supprimé avec succès à l'individu " + id);
        } catch (InitiativeNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "L'initiative ID " + initiativeId + "n'a pas été trouvé");
        }
        System.out.println("Suppression");
        return "redirect:/individu/{id}";
    }

    @GetMapping("/individu/{id}/editRessource/{ressourceId}")
    public String mettreAjourRessource(@PathVariable(name ="id" ) Integer id,@PathVariable(name ="ressourceId" ) Integer ressourceId, RedirectAttributes redirectAttributes, Model model){
        try {
            IndividuSolidaire individu = service.trouverIndividu(id);
            Ressources uneRessource = service.trouverRessource(ressourceId);

            model.addAttribute("individu",individu);
            model.addAttribute("uneRessource",uneRessource);
            model.addAttribute("pageTitle","Editer Ressource(ID : " + id + ")" );
            return "ressources_form";

        }catch (IndividuNotFoundException ex){
            redirectAttributes.addFlashAttribute("message","L'individu avec ID " +id + " est introuvable ");
        } catch (RessourceNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "La ressource ID " + ressourceId + "n'a pas été trouvé");
        }

        return "redirect:/individu/{id}";
    }

    @GetMapping("/individu/{id}/deleteRessource/{ressourceId}")
    public String supprimerRessourceIndividu(@PathVariable(name = "id") Integer id, @PathVariable(name = "ressourceId") Integer ressourceId, Model model, RedirectAttributes redirectAttributes) {
        try {

            service.supprimerRessourceIndividu(ressourceId);
            redirectAttributes.addFlashAttribute("message",
                    "La ressource ID " + ressourceId + " a été supprimé avec succès à l'individu " + id);
        } catch (RessourceNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", "La ressource ID " + ressourceId + "n'a pas été trouvé");
        }
        System.out.println("Suppression");
        return "redirect:/individu/{id}";
    }

    @GetMapping("/connexion_individu")
    public String afficherFormulaireConnexion(Model model){
        IndividuSolidaire individu = new IndividuSolidaire();
        model.addAttribute("individu", individu);
        model.addAttribute("pageTitle","Connexion Individu Solidaire");
        return "connexion_individu";
    }

    @PostMapping("/connexion_individu/verification")
    public String verifierConnexion(Model model, RedirectAttributes redirectAttributes, @Param("email") String email, @Param("password") String password, HttpServletRequest request, HttpServletResponse response){
        IndividuSolidaire individu =  service.rechercherIndividuParEmailMotDePasse(email,password);
        if(individu!=null){
            HttpSession session = request.getSession(true);
            session.setAttribute("id", individu.getId());
            session.setAttribute("nom", individu.getNom());
            session.setAttribute("prenom", individu.getPrenom());

            Cookie emailCookie = new Cookie("email",email);
            Cookie mdpCookie = new Cookie("password",password);
            emailCookie.setMaxAge(Duration.ofDays(60*60).getNano());
            mdpCookie.setMaxAge(Duration.ofDays(60*60).getNano());
            response.addCookie(emailCookie);
            response.addCookie(mdpCookie);
            model.addAttribute("individu", individu);
            System.out.println("session : " + session.getAttribute("nom"));
            return "redirect:/index";
        }else {
            redirectAttributes.addFlashAttribute("message", "L'email ou mot de passe invalide ");
            return "redirect:/connexion_individu";
        }
    }

    @GetMapping("/deconnexion")
    public String deconnexion(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request){
        Iterable<IndividuSolidaire> listIndividus = service.afficherIndividus();
        model.addAttribute("listIndividus",listIndividus);
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
}
