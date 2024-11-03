
package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "administrateurs")
public class AdministrateurPlateforme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(length = 45, nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(
            name = "administrateurs_individus",
            joinColumns = @JoinColumn(name = "administrateur_id"),
            inverseJoinColumns = @JoinColumn(name = "individu_id")
    )
    private List<IndividuSolidaire> individus;
    @ManyToMany
    @JoinTable(
            name = "administrateurs_organisateurs",
            joinColumns = @JoinColumn(name = "administrateur_id"),
            inverseJoinColumns = @JoinColumn(name = "organisateur_id")
    )
    private List<OrganisateurProjetSolidaire> organisateurs;

    public AdministrateurPlateforme() {
    }
    
    public AdministrateurPlateforme(int id, String email, String password, List<IndividuSolidaire> individus, List<OrganisateurProjetSolidaire> organisateurs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.individus = individus;
        this.organisateurs = organisateurs;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIndividus(List<IndividuSolidaire> individus) {
        this.individus = individus;
    }

    public void setOrganisateurs(List<OrganisateurProjetSolidaire> organisateurs) {
        this.organisateurs = organisateurs;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<IndividuSolidaire> getIndividus() {
        return individus;
    }

    public List<OrganisateurProjetSolidaire> getOrganisateurs() {
        return organisateurs;
    }
        @Override
       public String toString() {
           String message;
           message = String.format(" %-5d  %15s %30s %30s ",this.id,this.email, this.password, this.individus, this.organisateurs); 
           return message;
    }
}
