package com.rpgschool;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class JPATest {
    public static void main(String[] args) {
        System.out.println("Démarrage du test JPA/Hibernate");
// Création de l'EntityManagerFactory
        EntityManagerFactory emf = null;
        try {
// Connexion à l'unité de persistance définie dans persistence.xml
            emf = Persistence.createEntityManagerFactory("jpa-test");
            System.out.println("EntityManagerFactory créée avec succès!");
// Création d'un EntityManager
            EntityManager em = emf.createEntityManager();
            System.out.println("EntityManager créé avec succès!");
// Fermeture des ressources
            em.close();
            System.out.println("EntityManager fermé avec succès!");
            System.out.println("✅ Installation et configuration de JPA/Hibernate réussies!");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors du test JPA/Hibernate:");
            e.printStackTrace();
        } finally {
// Fermeture de l'EntityManagerFactory
            if (emf != null && emf.isOpen()) {
                emf.close();
                System.out.println("EntityManagerFactory fermée avec succès!");
            }
        }
    }
}