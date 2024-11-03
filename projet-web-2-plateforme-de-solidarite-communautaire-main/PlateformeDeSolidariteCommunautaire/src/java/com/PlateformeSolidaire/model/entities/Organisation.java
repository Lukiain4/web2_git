/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.entities;

/**
 *
 * @author i5 4460 gtx 1060
 */
public class Organisation {
    private int id;
    private String nom;
    private Projet projet;

    public Organisation() {
    }

    public Organisation(int id, String nom, Projet projet) {
        this.id = id;
        this.nom = nom;
        this.projet = projet;
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

    public Projet getProjet() {
        return projet;
    }
    
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    
    @Override
    public String toString() {
        String message;
        message = String.format(" %-5d  %15s %20s ",this.id,this.nom, this.projet); 
        return message;
    }
}
