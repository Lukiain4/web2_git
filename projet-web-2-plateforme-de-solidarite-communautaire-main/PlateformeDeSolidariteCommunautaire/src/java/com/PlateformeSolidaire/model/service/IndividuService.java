/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.service;

import com.PlateformeSolidaire.model.dao.IndividuSolidaireDao;
import com.PlateformeSolidaire.model.entities.Role;
import com.PlateformeSolidaire.model.entities.IndividuSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import java.util.List;

/**
 *
 * @author Lesly
 */
public class IndividuService {
    private IndividuSolidaireDao dao;
  
    private List<IndividuSolidaire> listeIndividus;
    IndividuSolidaire individu = null;
    boolean retour = false;
    List<Role> listRoles = null;
    List<Projet> listProjets = null;
  
     public IndividuService(IndividuSolidaireDao individuDao) {
        this.dao = individuDao;
    }
    public List<IndividuSolidaire> afficherLesIndividus() {
        listeIndividus = dao.findAll();
        return listeIndividus;
    }
    
    public List<Projet> afficherLesProjets() {
        listProjets = dao.findAllProjet();
        return listProjets;
    }
    
    public boolean rejoindreProjet(IndividuSolidaire individu, String nomProjet) {
        if (dao.create(individu, nomProjet)) {
            retour = true;
        }
        return retour;
    }    
    
    /*
    public List<Role> afficherLesRoles() {
        listRoles = dao.findAllRole();
        return listRoles;
    }

    public IndividuSolidaire chercherIndividuParNom(String nom) {
        individu = dao.findByName(nom);
        return individu;
    }
    */
    public IndividuSolidaire chercherIndividuParID(int id) {
        individu = dao.findById(id);
        return individu;
    }
    /*
    public IndividuSolidaire chercherIndividuParNomRole(String nomRole) {
        individu = dao.findByNameRole(nomRole);
        return individu;
    }

    public List<IndividuSolidaire> trierUtilisateursParRole(String nomRole) {
        listeIndividus = dao.findAllByNameRole(nomRole);
        return listeIndividus;
    }

    public IndividuSolidaire verifierEmailMotDePasse(String email, String motDePasse) {
        individu = dao.existsByEmailAndPassword(email, motDePasse);
        return individu;
    }
    */
    
    public boolean ajouterUnIndividu(IndividuSolidaire individu) {
        if (dao.create(individu)) {
            retour = true;
        }
        return retour;
    } 
    
    public boolean supprimerUnIndividu(int id) {
        if (dao.delete(id)) {
            retour = true;
        }
        return retour;
    }

    public boolean modifierUnIndividu(IndividuSolidaire individu) {
        if (dao.update(individu)) {
            retour = true;
        }
        return retour;
    }
 
}
