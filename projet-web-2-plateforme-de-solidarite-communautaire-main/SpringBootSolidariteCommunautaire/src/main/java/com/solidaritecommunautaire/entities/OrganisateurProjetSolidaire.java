package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "organisateurs")
public class OrganisateurProjetSolidaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 45, nullable = false, unique = true)
    private String nom;
    @Column(length = 45, nullable = false)
    private String prenom;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(length = 45, nullable = false)
    private String password;
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "organisateurs_projets",
            joinColumns = @JoinColumn(name = "organisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "projet_id")
    )
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