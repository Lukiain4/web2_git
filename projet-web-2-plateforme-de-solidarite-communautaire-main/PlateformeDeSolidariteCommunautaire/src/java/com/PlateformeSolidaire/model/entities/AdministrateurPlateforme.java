/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.entities;

import java.util.List;

/**
 *
 * @author i5 4460 gtx 1060
 */
public class AdministrateurPlateforme {
    private int id;
    private String email;
    private String password;
    private List<IndividuSolidaire> individus;
    private List<OrganisateurProjetSolidaire> organisateurs;

    public AdministrateurPlateforme() {
    }
    
    public AdministrateurPlateforme(int id, String email, String password, List<IndividuSolidaire> individus, List<OrganisateurProjetSolidaire> organisateurs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.individus = individus;
        this.organisateurs = organisateurs;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIndividus(List<IndividuSolidaire> individus) {
        this.individus = individus;
    }

    public void setOrganisateurs(List<OrganisateurProjetSolidaire> organisateurs) {
        this.organisateurs = organisateurs;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<IndividuSolidaire> getIndividus() {
        return individus;
    }

    public List<OrganisateurProjetSolidaire> getOrganisateurs() {
        return organisateurs;
    }
        @Override
       public String toString() {
           String message;
           message = String.format(" %-5d  %15s %30s %30s ",this.id,this.email, this.password, this.individus, this.organisateurs); 
           return message;
    }
}
