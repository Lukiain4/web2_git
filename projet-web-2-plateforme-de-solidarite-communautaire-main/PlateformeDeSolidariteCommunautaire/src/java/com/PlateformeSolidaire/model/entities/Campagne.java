/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.entities;

/**
 *
 * @author i5 4460 gtx 1060
 */
public class Campagne {
    private int id;
    private String nom;
    private String description;

    public Campagne() {
    }

    public Campagne(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
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
    
    @Override
    public String toString() {
        String message;
        message = String.format(" %-5d  %15s %30s ",this.id,this.nom, this.description); 
        return message;
    }
}
