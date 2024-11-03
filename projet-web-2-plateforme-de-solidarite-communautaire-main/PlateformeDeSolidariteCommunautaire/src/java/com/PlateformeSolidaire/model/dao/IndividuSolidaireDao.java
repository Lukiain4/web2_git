/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.IndividuSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import java.util.List;

/**
 *
 * @author Lesly
 */
public interface IndividuSolidaireDao {
    
    public boolean create(IndividuSolidaire individu);
    
    public boolean update(IndividuSolidaire individu);
    
    public boolean delete(int id);
    
    public List<IndividuSolidaire> findAll();
    
    public IndividuSolidaire findById(int id);
    
    public IndividuSolidaire findByEmail(String email);
    
    public List<Projet> findAllProjet();
    
    public boolean create(IndividuSolidaire individu, String nomProjet);
    
    //public Projet rejoindreProjet();
    //public InitiativeCaritative proposerInitiativeCaritative(InitiativeCaritative initiative);
    //public void consulterInitiativePropose();
    //public int faireDonFinancier(int donFinancier);
    //public String faireDonMateriel(String donMateriel);
    //public double offrirTempsBenevolePourCausesSpecifiques(double temps);
    //public HistoireEtRessource partagerHistoiresEtRessources(HistoireEtRessource histoire);
    //public void consulterHistoireEtRessource();
}
