package com.rpgschool.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Inventaire {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int capaciteMax;
    private int poidsActuel;

    @OneToMany(mappedBy = "inventaire", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<EmplacementInventaire> emplacements;

    @ManyToOne(fetch = FetchType.LAZY)
    private Personnage personnage;

    public Inventaire() {
    }

    public UUID getId() {
        return id;
    }

    public int getPoidsActuel() {
        return poidsActuel;
    }

    public void setPoidsActuel(int poidsActuel) {
        this.poidsActuel = poidsActuel;
    }

    public List<EmplacementInventaire> getEmplacements() {
        return emplacements;
    }

    public void setEmplacements(List<EmplacementInventaire> emplacements) {
        this.emplacements = emplacements;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }
}