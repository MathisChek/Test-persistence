package com.rpgschool.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String nom;
    private int niveau;
    private int experience;
    //Caractéristiques
    private int age;
    private int vie;
    private int intelligence;
    private int force;
    private int rapidite;
    private int mort;


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

    @OneToOne(mappedBy = "personnage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Statistiques statistiques;

    @OneToMany(mappedBy = "personnage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inventaire> inventaire;

    @OneToMany(mappedBy = "personnage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Competence> competences;

    @OneToMany(mappedBy = "personnage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipement> equipement;

    public Personnage() {
    }

    public UUID getId() {
        return id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int _niveau) {
        if (_niveau > this.niveau ? true : false) {
            System.out.println("Augmentation de niveau.");
            this.force +=  _niveau - this.niveau ;
            this.intelligence += _niveau - this.niveau ;
            this.niveau = _niveau;
        }
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

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    // Méthodes pour gérer la relation
    public void addCompetence(Competence competence) {
        if(this.competences == null) {
            this.competences = new ArrayList<Competence>();
        }
        competences.add(competence);
        competence.setPersonnage(this);
    }

    public void removeCompetence(Competence competence) {
        competences.remove(competence);
        competence.setPersonnage(null);
    }




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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getRapidite() {
        return rapidite;
    }

    public void setRapidite(int rapidite) {
        this.rapidite = rapidite;
    }

    public int getMort() {
        return mort;
    }

    public void setMort(int mort) {
        this.mort = mort;
    }

    //Affiche toute les informations de Personnage,
    // ainsi que des differents objets lié à celle-ci
    public void showAllFields(){

    }

    @Override
    public String toString() {
        StringBuilder competencesToString = new StringBuilder();
        for(Competence competence : competences) {
            competencesToString.append(competence.toString()).append("\n");
        }

        StringBuilder equipementToString = new StringBuilder();
        for(Equipement equipementItem : equipement) {
            equipementToString.append(equipementItem.toString()).append("\n");
        }

        return "Personnage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", experience=" + experience +
                ", age=" + age +
                ", vie=" + vie +
                ", intelligence=" + intelligence +
                ", force=" + force +
                ", rapidite=" + rapidite +
                ", mort=" + mort +
                ", type=" + type +
                ", dateCreation=" + dateCreation +
                ", inventaire=" + ( inventaire == null ? "": inventaire.toString())  +
                ", competences=" + (competences== null  ? "" : competences.toString())+
                ", equipement=" + (equipementToString) +
                '}';
    }
}
