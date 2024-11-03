/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lesly
 */
public class Projet {
    private int id;
    private String nom;
    private String description;
    
    List<Role> roles;

    public Projet() {
        this.roles = new ArrayList();
    }

    public Projet(int id, String nom, String description, int roles) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.roles = new ArrayList();
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }    
    
    public void ajouter(Role role){
        this.roles.add(role); 
    }
    
    @Override
       public String toString() {
           String message;
           message = String.format(" %-5d  %15s %30s %15s",this.id,this.nom, this.description, this.roles); 
           return message;
    }
  
}   
