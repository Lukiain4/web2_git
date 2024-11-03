/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.OrganisateurProjetSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import com.PlateformeSolidaire.model.entities.Role;
import java.util.List;

/**
 *
 * @author Lesly
 */
public interface OrganisateurProjetSolidaireDao {
    
    
    public boolean create(OrganisateurProjetSolidaire organisateur);
    
    public boolean update(OrganisateurProjetSolidaire organisateur);
    
    public boolean delete(int id);
    
    public List<OrganisateurProjetSolidaire> findAll();
    
    public OrganisateurProjetSolidaire findById(int id);
    
    public OrganisateurProjetSolidaire findByEmail(String email);
    
    public List<Role> findAllRoles();
    
    public boolean creerProjetSolidaire(Projet projet);
    
    public List<Projet> findAllProjets();
    
    public boolean deleteProjet(int id);
    
    public Projet findProjetById(int id);
//    public void consulterProjets();
//    public void rejoindreProjet();
//    public InitiativeCaritative proposerInitiativeCaritative(InitiativeCaritative initiative);
//    public void consulterInitiativePropose();
//    public int faireDonFinancier(int donFinancier);
//    public String faireDonMateriel(String donMateriel);
//    public double offrirTempsBenevolePourCausesSpecifiques(double temps);
//    public HistoireEtRessource partagerHistoiresEtRessources(HistoireEtRessource histoire);
//    public void consulterHistoireEtRessource();
//    public void creerProjetSolidaire();
//    public void gererProjetSolidaire();
//    public void IndividuSolidaire(IndividuSolidaire membre); 
//    public void suivreProgression();
//    public void informerResultats();
//    public void gererRessources();
    
}
