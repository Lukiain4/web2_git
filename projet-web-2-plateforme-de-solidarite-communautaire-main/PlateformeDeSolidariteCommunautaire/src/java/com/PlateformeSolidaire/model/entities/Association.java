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
public class Association {
    private int id;
    private String nomAssociation;
    private String email;
    private String password;
    private List<Campagne> campagnesCollecte;

    public Association() {
    }

    public Association(int id, String nomAssociation, String email, String password, List<Campagne> campagnesCollecte) {
        this.id = id;
        this.nomAssociation = nomAssociation;
        this.email = email;
        this.password = password;
        this.campagnesCollecte = campagnesCollecte;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomAssociation() {
        return nomAssociation;
    }

    public void setNomAssociation(String nomAssociation) {
        this.nomAssociation = nomAssociation;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Campagne> getCampagnesCollecte() {
        return campagnesCollecte;
    }

    public void setCampagnesCollecte(List<Campagne> campagnesCollecte) {
        this.campagnesCollecte = campagnesCollecte;
    }
    
    @Override
    public String toString() {
        String message;
        message = String.format(" %-5d  %255s %20s %25s ",this.id, this.nomAssociation, this.email, this.password, this.campagnesCollecte); 
        return message;
    }
}
