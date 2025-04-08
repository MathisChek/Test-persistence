package com.rpgschool.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Statistiques {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int force;
    private int intelligence;
    private int agilite;
    private int endurance;
    private int chance;

    @OneToOne
    @JoinColumn(name = "personnage_id")
    private Personnage personnage;

    public Statistiques() {
    }

    public UUID getId() {
        return id;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgilite() {
        return agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }


}