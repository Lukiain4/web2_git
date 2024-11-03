/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lesly
 */
public class OrganisateurProjetSolidaire {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Role role;
    private List<Projet> projets;
    
    public OrganisateurProjetSolidaire(){
    }

    public OrganisateurProjetSolidaire(int id, String nom, String prenom, String email, String password, Role role, List<Projet> projets) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
        this.projets = projets;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
    @Override
    public String toString() {
       String message;
       message = String.format(" %-10d %15b %30s %15s %25s %15s %25s",this.id,this.nom,this.email,this.prenom,this.password,this.role,this.projets); 
       return message;
    }
}