package com.rpgschool.repository;

import com.rpgschool.entity.Personnage;
import com.rpgschool.entity.Equipement;
import com.rpgschool.entity.TypeEquipement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class GameRepositoryImpl implements GameRepository {

    @PersistenceContext
    private EntityManager em;

    public GameRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Personnage> findAllCharacters() {
        return em.createQuery("SELECT p FROM Personnage p", Personnage.class)
                .getResultList();
    }

    @Override
    public List<Personnage> findCharactersByMinLevel(int minLevel) {
        return em.createQuery("SELECT p FROM Personnage p WHERE p.niveau >= :minLevel", Personnage.class)
                .setParameter("minLevel", minLevel)
                .getResultList();
    }

    @Override
    public List<Equipement> findWeaponsByMinPower(int minPower) {
        return em.createQuery("SELECT e FROM Equipement e WHERE e.type = :type AND e.bonus > :minPower", Equipement.class)
                .setParameter("type", TypeEquipement.ARME)
                .setParameter("minPower", minPower)
                .getResultList();
    }
}