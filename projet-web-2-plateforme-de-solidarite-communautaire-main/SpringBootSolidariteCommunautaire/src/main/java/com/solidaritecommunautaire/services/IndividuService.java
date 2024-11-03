package com.solidaritecommunautaire.services;

import com.solidaritecommunautaire.entities.*;
import com.solidaritecommunautaire.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IndividuService {
    @Autowired
    IndividuRepository repos;

    @Autowired
    AdministrateurRepository reposAdmin;

    @Autowired
    OrganisateurRepository reposOrg;

    @Autowired
    ProjetRepository reposProjet;

    @Autowired
    RoleRepository reposRole;

    @Autowired
    DonRepository reposDon;

    @Autowired
    RessourceRepository reposRess;

    @Autowired
    InitiativeRepository reposInit;

    public List<IndividuSolidaire> afficherIndividus(){
        return ( List<IndividuSolidaire> ) repos.findAll();
    }

    public List<Role> afficherRoles() { return ( List<Role> ) reposRole.findAll(); }

    public List<Projet> afficherProjets(){
            return ( List<Projet> ) reposProjet.findAll();
        }

    public IndividuSolidaire enregistrerIndividu(IndividuSolidaire individu){ return repos.save(individu); }

    public AdministrateurPlateforme enregistrerAdministrateur(AdministrateurPlateforme admin){
        return reposAdmin.save(admin);
    }
    public OrganisateurProjetSolidaire enregistrerOrganisateur(OrganisateurProjetSolidaire organisateur){
        return reposOrg.save(organisateur);
    }

    public boolean isEmailIndividuUnique(String email,Integer id) {
        IndividuSolidaire individuByEmail = repos.getIndividuByEmail(email);

        if (individuByEmail == null) return true;

        boolean isCreatingNewUser = false;
        if (id == null){
            isCreatingNewUser=true;
        }

        if(isCreatingNewUser){

            if (individuByEmail != null) return false;
        }else{

            if (individuByEmail.getId() != id) {
                return false;
            }
        }

        return true;

    }

    public List<Projet> trouverProjetsIndividu(Integer id){
        return reposProjet.findAllByIdIndividu(id);
    }

    public List<Ressources> trouverRessourcesIndividu(Integer id){
        return reposRess.findAllByIdIndividu(id);
    }


    public List<Dons> trouverDonsIndividu(Integer id){
        return reposDon.findAllByIdIndividu(id);
    }

    public List<InitiativeCaritative> trouverInitiativesIndividu(Integer id){
        return reposInit.findAllByIdIndividu(id);
    }

    public IndividuSolidaire trouverIndividu(Integer id) throws IndividuNotFoundException {

        try {
            return repos.findById(id).get();

        }catch (NoSuchElementException ex){
            throw new IndividuNotFoundException("On ne peut pas trouver un individu avec l'id " +id);
        }

    }

    public Projet trouverProjet(Integer id) throws ProjetNotFoundException {

        try {
            return reposProjet.findById(id).get();

        }catch (NoSuchElementException ex){
            throw new ProjetNotFoundException("On ne peut pas trouver un projet avec l'id " +id);
        }

    }

    public Ressources trouverRessource(Integer id) throws RessourceNotFoundException {

        try {
            return reposRess.findById(id).get();

        }catch (NoSuchElementException ex){
            throw new RessourceNotFoundException("On ne peut pas trouver une ressource avec l'id " +id);
        }

    }

    public InitiativeCaritative trouverInitiative(Integer id) throws InitiativeNotFoundException {

        try {
            return reposInit.findById(id).get();

        }catch (NoSuchElementException ex){
            throw new InitiativeNotFoundException("On ne peut pas trouver une initiative avec l'id " +id);
        }

    }

    public void supprimerInitiativeIndividu(Integer id) throws InitiativeNotFoundException {
        Long countById = reposInit.countById(id);
        //pas d'utilisateur dans la bd
        if (countById == null || countById == 0) {
            throw new InitiativeNotFoundException("On ne peut pas trouver une initiative avec l'id" + id);
        }

        reposInit.deleteById(id);
    }

    public void supprimerRessourceIndividu(Integer id) throws RessourceNotFoundException {
        Long countById = reposRess.countById(id);
        //pas d'utilisateur dans la bd
        if (countById == null || countById == 0) {
            throw new RessourceNotFoundException("On ne peut pas trouver une ressource avec l'id" + id);
        }

        reposRess.deleteById(id);
    }

    public IndividuSolidaire rechercherIndividuParEmailMotDePasse(String email,String password) {
        //On cherche un utilisateur à partir de son email
        IndividuSolidaire individuByEmailAndPassword = repos.getIndividuByEmailAndPassword(email,password);
        if(individuByEmailAndPassword==null){
            return null;
        }
        return individuByEmailAndPassword;
    }


}
