package com.rpgschool;

import com.rpgschool.entity.*;
import com.rpgschool.repository.GameRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        Personnage p = new Personnage();
        p.setNom("Arthas");
        p.setNiveau(10);
        p.setExperience(2500);

        em.getTransaction().begin();
        em.persist(p); // l'objet est ajouté au contexte de persistance
        em.getTransaction().commit(); // il est inséré en base



        GameRepositoryImpl repo = new GameRepositoryImpl(em);
        List<Personnage> persos = repo.findAllCharacters();
        List<Personnage> arthas = repo.findCharacterByName("tha");
        List<Personnage> minlevel = repo.findCharactersByMinLevel( 1);

        System.out.println("🎮 Personnages en base :");
        for (Personnage pe : persos) {
            System.out.println("- " + pe.getNom() + " (niveau " + pe.getNiveau() + ")");
        }

        System.out.println("🎮 Personnages avec tha :");
        for (Personnage pe : arthas) {
            System.out.println("- " + pe.getNom() + " (niveau " + pe.getNiveau() + ")");
        }

        System.out.println("🎮 Personnages plus de niv10 :");
        for (Personnage pe : minlevel) {
            System.out.println("- " + pe.getNom() + " (niveau " + pe.getNiveau() + ")");
        }
    }
}