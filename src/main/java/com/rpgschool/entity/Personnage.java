package com.rpgschool.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nom;
    private int niveau;
    private int experience;


    @Enumerated(EnumType.STRING)
    private Type_Personnage type;

    public Type_Personnage getType() {
        return type;
    }

    public void setType(Type_Personnage type) {
        this.type = type;
    }

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    public Personnage() {
    }

    public UUID getId() {
        return id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Statistiques getStatistiques() {
        return statistiques;
    }

    public List<Inventaire> getInventaire() {
        return inventaire;
    }

    public List<ApprentissageCompetence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<ApprentissageCompetence> competences) {
        this.competences = competences;
    }

    @OneToOne(mappedBy = "personnage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Statistiques statistiques;

    @OneToMany(mappedBy = "personnage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inventaire> inventaire;

    @OneToMany(mappedBy = "personnage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApprentissageCompetence> competences;



    @OneToMany(mappedBy = "personnage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipement> equipement;


    public List<Equipement> getEquipement() {
        return equipement;
    }

    public void setEquipement(List<Equipement> equipement) {
        this.equipement = equipement;
    }

    public void setStatistiques(Statistiques stats) {
        this.statistiques = stats;
        if (stats != null) {
            stats.setPersonnage(this);
        }
    }

    public void setInventaire(List<Inventaire> inventaire) {
        this.inventaire = inventaire;
    }

    public void addInventaire(Inventaire inventaire) {
        this.inventaire.add(inventaire);
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", experience=" + experience +
                ", type=" + type +
                ", dateCreation=" + dateCreation +
                ", statistiques=" + statistiques +
                ", inventaire=" + inventaire +
                ", competences=" + competences +
                ", equipement=" + equipement +
                '}';
    }
}
