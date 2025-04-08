package com.rpgschool.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private TypeEquipement type;

    @Enumerated(EnumType.STRING)
    private Type_Personnage specificite;

    @Enumerated(EnumType.STRING)
    private RareteEquipement rarete;

    @ManyToOne(fetch = FetchType.LAZY)
    private Personnage personnage;

    public Type_Personnage getSpecificite() {
        return specificite;
    }

    public void setSpecificite(Type_Personnage specificite) {
        this.specificite = specificite;
    }

    private int bonus;

    // Getters et setters...

    public UUID getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeEquipement getType() {
        return type;
    }

    public void setType(TypeEquipement type) {
        this.type = type;
    }

    public RareteEquipement getRarete() {
        return rarete;
    }

    public void setRarete(RareteEquipement rarete) {
        this.rarete = rarete;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type=" + type +
                ", specificite=" + specificite +
                ", rarete=" + rarete +
                ", bonus=" + bonus +
                '}';
    }
}
