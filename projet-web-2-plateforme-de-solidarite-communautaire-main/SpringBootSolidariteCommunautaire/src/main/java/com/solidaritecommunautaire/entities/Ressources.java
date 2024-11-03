package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ressources")
public class Ressources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45, nullable = false)
    private String nom;

    @Column(length = 254, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "individu_id", nullable = false)
    private IndividuSolidaire individu;

    public Ressources() {
    }

    public Ressources(int id, String nom, String description, IndividuSolidaire individu) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.individu = individu;
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

    public IndividuSolidaire getIndividu() {
        return individu;
    }

    public void setIndividu(IndividuSolidaire individu) {
        this.individu = individu;
    }

    @Override
    public String toString() {
        return "Ressources{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ressources='" + description + '\'' +
                ", individu=" + individu +
                '}';
    }
}
