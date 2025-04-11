package com.rpgschool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@IdClass(ApprentissageCompetenceId.class)
@Table(name = "PERSONNAGE_COMPETENCES")
public class ApprentissageCompetence {
    @Id
    @ManyToOne
    @JoinColumn(name = "personnage_id")
    private Personnage personnage;

    @Id
    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;

    private int niveauMaitrise;

    @Temporal(TemporalType.DATE)
    private Date dateApprentissage;

    private int pointsExperience;

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public Date getDateApprentissage() {
        return dateApprentissage;
    }

    public void setDateApprentissage(Date dateApprentissage) {
        this.dateApprentissage = dateApprentissage;
    }

    public int getNiveauMaitrise() {
        return niveauMaitrise;
    }

    public void setNiveauMaitrise(int niveauMaitrise) {
        this.niveauMaitrise = niveauMaitrise;
    }

    public int getPointsExperience() {
        return pointsExperience;
    }

    public void setPointsExperience(int pointsExperience) {
        this.pointsExperience = pointsExperience;
    }
}

class ApprentissageCompetenceId implements Serializable {
    private UUID personnage;
    private UUID competence;

    // equals() et hashCode() requis
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprentissageCompetenceId that = (ApprentissageCompetenceId) o;
        return personnage.equals(that.personnage) && competence.equals(that.competence);
    }

    public UUID getPersonnage() {
        return personnage;
    }

    public void setPersonnage(UUID personnage) {
        this.personnage = personnage;
    }

    public UUID getCompetence() {
        return competence;
    }

    public void setCompetence(UUID competence) {
        this.competence = competence;
    }

    public int hashCode() {
        return personnage.hashCode() + competence.hashCode();
    }
}
