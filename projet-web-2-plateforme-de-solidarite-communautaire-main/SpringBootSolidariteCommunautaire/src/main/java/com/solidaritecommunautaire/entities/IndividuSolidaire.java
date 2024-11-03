package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "individus")
public class IndividuSolidaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 45, nullable = false, unique = true)
    private String nom;
    @Column(length = 45, nullable = false)
    private String prenom;
    @Column(length = 128, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "individu")
    private Set<Dons> dons;

    @OneToMany(mappedBy = "individu")
    private Set<InitiativeCaritative> initiatives;

    @OneToMany(mappedBy = "individu")
    private Set<Ressources> ressources;

    @ManyToMany
    @JoinTable(
            name = "individus_projets",
            joinColumns = @JoinColumn(name = "individu_id"),
            inverseJoinColumns = @JoinColumn(name = "projet_id"))
    private Set<Projet> projets = new HashSet<>();

    public IndividuSolidaire() {
    }

    public IndividuSolidaire(int id, String nom, String prenom, String email, String password, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
        this.projets = new HashSet<>();
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

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public Set<Projet> getProjets() { return projets; }

    public void setProjets(Set<Projet> projets) { this.projets = projets; }

    public Set<Dons> getDons() {
        return dons;
    }

    public void setDons(Set<Dons> dons) {
        this.dons = dons;
    }

    public Set<InitiativeCaritative> getInitiatives() {
        return initiatives;
    }

    public void setInitiatives(Set<InitiativeCaritative> initiatives) {
        this.initiatives = initiatives;
    }

    public Set<Ressources> getRessources() {
        return ressources;
    }

    public void setRessources(Set<Ressources> ressources) {
        this.ressources = ressources;
    }

    @Override
    public String toString() {
        return "IndividuSolidaire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", dons=" + dons +
                ", initiatives=" + initiatives +
                ", ressources=" + ressources +
                ", projets=" + projets +
                '}';
    }
}
