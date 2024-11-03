/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.service;

import com.PlateformeSolidaire.model.dao.OrganisateurProjetSolidaireDao;
import com.PlateformeSolidaire.model.entities.OrganisateurProjetSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import com.PlateformeSolidaire.model.entities.Role;
import java.util.List;

/**
 *
 * @author i5 4460 gtx 1060
 */
public class OrganisateurService {
    private OrganisateurProjetSolidaireDao dao;
  
    private List<OrganisateurProjetSolidaire> listeOrganisateurs;
    OrganisateurProjetSolidaire organisateur = null;
    boolean retour = false;
    List<Role> listRoles = null;
    List<Projet> listProjets = null;
    Projet projet = null;
  
     public OrganisateurService(OrganisateurProjetSolidaireDao organisateurDao) {
        this.dao = organisateurDao;
    }
    public List<OrganisateurProjetSolidaire> afficherLesOrganisateurs() {
        listeOrganisateurs = dao.findAll();
        return listeOrganisateurs;
    }

    public List<Role> afficherLesLesRoles() {
        listRoles = dao.findAllRoles();
        return listRoles;
    }
    
    public List<Projet> afficherLesLesProjets() {
        listProjets = dao.findAllProjets();
        return listProjets;
    }
    
    public boolean ajouterUnProjet(Projet projet) {

        if (dao.creerProjetSolidaire(projet)) {
            retour = true;
        }
        return retour;
    }

//    public Utilisateur chercherUtilisateurParNom(String nom) {
//        utilisateur = dao.findByName(nom);
//        return utilisateur;
//    }
//
    public Projet chercherProjetParID(int id) {
        projet = dao.findProjetById(id);
        return projet;
    }
//
//    public Utilisateur chercherUtilisateurParNomRole(String nomRole) {
//        utilisateur = dao.findByNameRole(nomRole);
//        return utilisateur;
//    }
//
//    public List<Utilisateur> trierUtilisateursParRole(String nomRole) {
//        listeUtilisateurs = dao.findAllByNameRole(nomRole);
//        return listeUtilisateurs;
//    }
//
//    public Utilisateur verifierEmailMotDePasse(String email, String motDePasse) {
//        utilisateur = dao.existsByEmailAndPassword(email, motDePasse);
//        return utilisateur;
//    }
//
    public boolean supprimerUnProjet(int id) {
        if (dao.deleteProjet(id)) {
            retour = true;
        }
        return retour;
    }
//
//    public boolean modifierUnUtilisateur(Utilisateur utilisateur) {
//        if (dao.update(utilisateur)) {
//            retour = true;
//        }
//
//        return retour;
//    }
//
//        public boolean ajouterUnUtilisateurAvecUnRole(Utilisateur utilisateur, String nomRole) {
//
//        if (dao.create(utilisateur, nomRole)) {
//            retour = true;
//        }
//
//        return retour;
//    }
}
