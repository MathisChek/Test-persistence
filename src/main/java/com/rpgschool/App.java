package com.rpgschool;

import com.rpgschool.entity.*;
import com.rpgschool.repository.GameRepository;
import com.rpgschool.repository.GameRepositoryImpl;
import com.rpgschool.utils.PersonnageUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();




        GameRepositoryImpl repo = new GameRepositoryImpl(em);
        try {
            em.getTransaction().begin();
           // int deletedPersonnage = repo.deleteAllByName("Arthas");
            //System.out.println("Perso supprimed : " + deletedPersonnage);
            PersonnageUtils utils = new PersonnageUtils();
            List<Personnage> persos = utils.generateListPersonnage();
            for (Personnage p : persos) {
                em.persist(p);
            }

           // l'objet est ajouté au contexte de persistance
            em.getTransaction().commit(); // il est inséré en base
        }catch (Exception e) {
            System.out.println("Erreur de persistance" + e.getMessage().toString());
        }

        List<Personnage> persos = repo.findAllCharacters();
        List<Personnage> arthas = repo.findCharacterByName("tha");
        List<Personnage> minlevel = repo.findCharactersByMinLevel( 1);

        Inventaire myInventaire = new Inventaire();

        System.out.println("🎮 Personnages en base :");
        for (Personnage pe : persos) {
            System.out.println("- " + pe.getNom() + " (niveau " + pe.getNiveau() + ")");
        }


        List<Personnage> typeLevel = repo.findTypePersonnage(Type_Personnage.GUERRIER, 5);

        System.out.println("liste des persos avec une arme");
        List<Personnage> filteredMaxPowerWeapon = repo.findCharactersWithMostPowerfulEquipment(TypeEquipement.ARME );
        for(Personnage perso : filteredMaxPowerWeapon ){
            System.out.println(perso.toString());
        }

        Personnage personnageFetched = repo.findByNameWithJoin("Arthas");
        System.out.println("Personnage Fetched : " + (personnageFetched != null ?personnageFetched.toString(): 0));
        repo.massExpGain();
        System.out.println("Exp gagné pour toute l'équipe : " );
        filteredMaxPowerWeapon = repo.findCharactersWithMostPowerfulEquipment(TypeEquipement.ARME );
        for(Personnage perso : filteredMaxPowerWeapon ){
            System.out.println(perso.toString());
        }
    }
}