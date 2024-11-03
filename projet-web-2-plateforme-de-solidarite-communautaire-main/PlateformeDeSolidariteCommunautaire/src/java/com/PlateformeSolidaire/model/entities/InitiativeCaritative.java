/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.entities;

/**
 *
 * @author i5 4460 gtx 1060
 */
public class InitiativeCaritative {
    private int id;
    private String nom;
    private String description;
    private int roles;

    public InitiativeCaritative(int id, String nom, String description, int roles) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.roles = roles;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }  
    
    @Override
       public String toString() {
           String message;
           message = String.format(" %-5d  %15s %30s %15s ",this.id,this.nom, this.description, this.roles); 
           return message;
    }
  
}
