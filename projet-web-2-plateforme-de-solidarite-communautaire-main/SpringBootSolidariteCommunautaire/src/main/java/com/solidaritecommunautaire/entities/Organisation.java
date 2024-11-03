package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "organisations")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 90, nullable = false, unique = true)
    private String nom;
    @Column(length = 255, nullable = false)
    private String description;
    @OneToMany(mappedBy = "organisation")
    private List<Projet> projet;

    public Organisation() {
    }

    public Organisation(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
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

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Projet> getProjet() {
        return projet;
    }
    
    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }
    
    @Override
    public String toString() {
        String message;
        message = String.format(" %-5d  %15s %20s ",this.id,this.nom, this.projet); 
        return message;
    }
}
