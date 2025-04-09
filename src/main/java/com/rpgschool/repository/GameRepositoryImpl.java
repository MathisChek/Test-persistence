package com.rpgschool.repository;

import com.rpgschool.entity.Personnage;
import com.rpgschool.entity.Equipement;
import com.rpgschool.entity.TypeEquipement;

import com.rpgschool.entity.Type_Personnage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

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

    @Override
    public List<Personnage> findCharacterByName(String name) {
        return em.createQuery("SELECT p FROM Personnage p WHERE p.nom LIKE :name ", Personnage.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Personnage> findTypePersonnage(Type_Personnage type, int minLevel) {
        return em.createQuery("SELECT p FROM Personnage p WHERE p.type = :type AND p.niveau >= :minLevel ", Personnage.class)
                .setParameter("type", type)
                .setParameter("minLevel", minLevel)
                .getResultList();
    }

    @Override
    public List<Equipement> findWeaponsByClass(Type_Personnage typePersonnage, String name) {
        return em.createQuery("SELECT e FROM Equipement e WHERE e.specificite = :type AND e.nom LIKE :name ", Equipement.class)
                .setParameter("type", typePersonnage)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Personnage> getAllPersonnagesWithEquipment() {
            return em.createQuery(
                            "SELECT p FROM Personnage p LEFT JOIN FETCH p.equipement",
                            Personnage.class)
                    .getResultList();
    }

    @Override
    public List<Personnage> getAllByTypeEquipment(TypeEquipement equipementType) {
        return em.createQuery(
                        "SELECT p FROM Personnage p LEFT JOIN FETCH p.equipement  e where e.type= :type",
                        Personnage.class)
                .setParameter("type", equipementType)
                .getResultList();
    }

    @Override
    public List<Personnage> getAllCharacterWithSpecificWeapon(TypeEquipement equipmentType) {
        return null;
    }

    @Override
    public List<Personnage> getAllCharacterWithCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Personnage> query = cb.createQuery(Personnage.class);
        Root<Personnage> characterRoot = query.from(Personnage.class);
        query.select(characterRoot);
        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Personnage> getAllCharacterWithCriteriaAndMinLevel(int minLevel) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        EntityManager entityManager = em.getEntityManagerFactory().createEntityManager();
        CriteriaQuery<Personnage> query = cb.createQuery(Personnage.class);

        Root<Personnage> characterRoot = query.from(Personnage.class);
        Predicate levelPredicate = cb.greaterThanOrEqualTo(characterRoot.get("niveau"), minLevel);

        query.select(characterRoot);
        query.where(levelPredicate);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Equipement> getAllEquipmentWithCriteriaAndMinPower(int minPower) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        EntityManager entityManager = em.getEntityManagerFactory().createEntityManager();
        CriteriaQuery<Equipement> query = cb.createQuery(Equipement.class);

        Root<Equipement> characterRoot = query.from(Equipement.class);
        Predicate levelPredicate = cb.greaterThanOrEqualTo(characterRoot.get("puissance"), minPower);
        query.select(characterRoot);
        query.where(levelPredicate);
        return entityManager.createQuery(query).getResultList();
    }
}