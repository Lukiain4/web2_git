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
public class IndividuSolidaire {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;

    List<Role> roles;
    List<Projet> projets;
    
    public IndividuSolidaire() {
        this.roles = new ArrayList();
    }

    public IndividuSolidaire(int id, String nom, String prenom, String email, String password, Role role, Projet projet) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.roles = new ArrayList();
        this.projets = new ArrayList();
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public void ajouter(Role role){
        this.roles.add(role); 
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
    public void ajouter(Projet projet){
        this.projets.add(projet); 
    }
    
    @Override
       public String toString() {
           String message;
           message = String.format(" %-10d %15b %30s %15s %25s %15s",this.id,this.nom,this.email,this.prenom,this.password,this.roles);
           return message;
    }
}
