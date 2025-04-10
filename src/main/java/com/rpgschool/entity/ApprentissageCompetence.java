package com.rpgschool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

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
    private Long personnage;
    private Long competence;

    // equals() et hashCode() requis
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprentissageCompetenceId that = (ApprentissageCompetenceId) o;
        return personnage.equals(that.personnage) && competence.equals(that.competence);
    }

    public Long getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Long personnage) {
        this.personnage = personnage;
    }

    public Long getCompetence() {
        return competence;
    }

    public void setCompetence(Long competence) {
        this.competence = competence;
    }

    public int hashCode() {
        return personnage.hashCode() + competence.hashCode();
    }
}
