package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "projets")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 90, nullable = false, unique = true)
    private String nom;
    @Column(length = 255, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    private Organisation organisation;

    @ManyToMany(mappedBy = "projets")
    private Set<IndividuSolidaire> individus = new HashSet<>();



    public Projet() {

    }

    public Projet(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.individus = new HashSet<>();
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

    public Set<IndividuSolidaire> getIndividus() { return individus; }

    public void setIndividus(Set<IndividuSolidaire> individus) { this.individus = individus; }
    
    @Override
       public String toString() {
           String message;
           message = String.format(" %-5d  %15s %30s %15s",this.id,this.nom, this.description, this.individus);
           return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projet other = (Projet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hash(id);
        return hash;
    }
}
