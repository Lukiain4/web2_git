package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "campagnes")
public class Campagne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 90, nullable = false, unique = true)
    private String nom;
    @Column(length = 255, nullable = false)
    private String description;
    @Column(length = 64)
    private String photo;

    @Column(nullable = false)
    private double fond;

    @ManyToOne
    @JoinColumn(name = "association_id", nullable = false)
    private Association association;

    public Campagne() {
    }

    public Campagne(int id, String nom, String description, String photo, int fond, Association association) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.photo = photo;
        this.fond = fond;
        this.association = association;
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
    
     public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setFond(double fond) {
        this.fond = fond;
    }

    public double getFond() {
        return fond;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String afficherEnColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s", "Id", "Nom", "Description", "Fonds", "Photo");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }
    
    @Override
    public String toString() {
        String message;
        message = String.format(" %-5d  %15s %30s %15s %15s",this.id,this.nom, this.description, this.fond, this.photo, this.association);
        return message;
    }
}
