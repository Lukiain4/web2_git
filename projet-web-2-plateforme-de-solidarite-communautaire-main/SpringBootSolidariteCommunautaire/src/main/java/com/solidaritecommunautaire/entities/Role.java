package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 90, nullable = false, unique = true)
    private String nom;
    @Column(length = 255, nullable = false)
    private String description;

    public Role() {

    }

    public Role(int id, String nom, String description) {
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
