package com.rpgschool.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nom;
    private String description;
    private int coutMana;
    private int niveauRequis;

    @ManyToOne(fetch = FetchType.EAGER)
    private Personnage personnage;

    public int getCoutMana() {
        return coutMana;
    }

    public void setCoutMana(int coutMana) {
        this.coutMana = coutMana;
    }

    public int getNiveauRequis() {
        return niveauRequis;
    }

    public void setNiveauRequis(int niveauRequis) {
        this.niveauRequis = niveauRequis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public UUID getId() {
        return id;
    }



    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", coutMana=" + coutMana +
                ", niveauRequis=" + niveauRequis +
                ", personnage=" + personnage.getNom().toString()+
                '}';
    }
}

