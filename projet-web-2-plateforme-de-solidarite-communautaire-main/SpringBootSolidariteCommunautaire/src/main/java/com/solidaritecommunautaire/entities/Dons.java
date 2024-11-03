package com.solidaritecommunautaire.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dons")
public class Dons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 15)
    private Double financier;

    @Column(length = 254)
    private String materiel;

    @ManyToOne
    @JoinColumn(name = "individu_id", nullable = false)
    private IndividuSolidaire individu;

    public Dons() {
    }

    public Dons(int id, Double financier, IndividuSolidaire individu) {
        this.id = id;
        this.financier = financier;
        this.individu = individu;
    }

    public Dons(int id, String materiel, IndividuSolidaire individu) {
        this.id = id;
        this.materiel = materiel;
        this.individu = individu;
    }

    public Dons(int id, Double financier, String materiel, IndividuSolidaire individu) {
        this.id = id;
        this.financier = financier;
        this.materiel = materiel;
        this.individu = individu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getFinancier() {
        return financier;
    }

    public void setFinancier(Double financier) {
        this.financier = financier;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public IndividuSolidaire getIndividu() {
        return individu;
    }

    public void setIndividu(IndividuSolidaire individu) {
        this.individu = individu;
    }



    @Override
    public String toString() {
        return "Dons{" +
                "id=" + id +
                ", financier='" + financier + '\'' +
                ", materiel='" + materiel + '\'' +
                ", individu=" + individu +
                '}';
    }
}
