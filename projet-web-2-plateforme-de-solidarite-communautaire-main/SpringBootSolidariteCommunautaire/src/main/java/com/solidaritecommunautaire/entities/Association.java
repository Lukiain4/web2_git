package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "associations")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 90, nullable = false, unique = true)
    private String nomAssociation;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(length = 45, nullable = false)
    private String password;
    @Column(length = 64)
    private String photo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Campagne> campagnes;

    public Association() {
    }

    public Association(int id, String nomAssociation, String email, String password, String photo,List<Campagne> campagnes) {
        this.id = id;
        this.nomAssociation = nomAssociation;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.campagnes = campagnes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAssociation() {
        return nomAssociation;
    }

    public void setNomAssociation(String nomAssociation) {
        this.nomAssociation = nomAssociation;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Campagne> getCampagnes() {
        return campagnes;
    }

    public void setCampagnes(List<Campagne> campagnes) {
        this.campagnes = campagnes;
    }

    public String afficherEnColonnes() {
        String message = "";
        message = String.format(" %-10s  %30s %15s %15s %15s", "Id", "Nom", "Email", "Password", "Photo");
        message+="\n --------------------------------------------------------------------------------------------------------------------------------------";
        return message;
    }

    @Override
    public String toString() {
        String message;
        message = String.format(" %-5d  %25s %20s %25s ",this.id, this.nomAssociation, this.email, this.password, this.photo,this.campagnes);
        return message;
    }
}
