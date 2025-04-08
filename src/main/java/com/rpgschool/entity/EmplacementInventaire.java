package com.rpgschool.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class EmplacementInventaire {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int position;
    private int quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventaire_id")
    private Inventaire inventaire;

    public UUID getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }
}
