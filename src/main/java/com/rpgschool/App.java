package com.rpgschool;

import com.rpgschool.entity.*;
import com.rpgschool.repository.GameRepository;
import com.rpgschool.repository.GameRepositoryImpl;
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

        Personnage p = new Personnage();
        p.setNom("Arthas3");
        p.setNiveau(3);
        p.setExperience(2500);
        p.setType(Type_Personnage.GUERRIER);
        Equipement equipement = new Equipement();
        equipement.setNom("hache");
        equipement.setPuissance(0);
        equipement.setSpecificite(Type_Personnage.GUERRIER);
        List<Equipement> equipements = new ArrayList<Equipement>();
        equipements.add(equipement);
        p.setEquipement(equipements);

        Competence competence = new Competence();
        competence.setNom("Holy grenade");
        competence.setDescription("Holy grenade");
        competence.setCoutMana(50);
        competence.setNiveauRequis(5);
        p.addCompetence(competence);

        GameRepositoryImpl repo = new GameRepositoryImpl(em);
        try {
            em.getTransaction().begin();
           // int deletedPersonnage = repo.deleteAllByName("Arthas");
            //System.out.println("Perso supprimed : " + deletedPersonnage);
            em.persist(competence);
            em.persist(p); // l'objet est ajouté au contexte de persistance
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

        System.out.println("🎮 Personnages avec tha :");
        for (Personnage pe : arthas) {
            System.out.println("- " + pe.getNom() + " (niveau " + pe.getNiveau() + ")");
        }

        System.out.println("🎮 Personnages plus de niv10 :");
        for (Personnage pe : minlevel) {
            System.out.println("- " + pe.getNom() + " (niveau " + pe.getNiveau() + ")");
        }


        List<Personnage> typeLevel = repo.findTypePersonnage(Type_Personnage.GUERRIER, 5);

        System.out.println("🎮 type de Personnages plus de niv10 :");
        for (Personnage pe : typeLevel) {
            System.out.println("- " + pe.getNom() + " type : " + pe.getType() + " (niveau " + pe.getNiveau() + ")");
        }

        List<Equipement> equipementByType = repo.findWeaponsByClass(Type_Personnage.GUERRIER, "hac");
        System.out.println("🎮 Personnages plus de niv10 :");
        for (Equipement e : equipementByType) {
            System.out.println(" -Equipement :  " + e.toString());
        }

        List<Personnage> personnageListWithEquipment = repo.getAllPersonnagesWithEquipment();
        System.out.println("Liste de tout les personnes");
        for(Personnage perso : personnageListWithEquipment){
            System.out.println(perso.toString());
            System.out.println(perso.getEquipement().toString());
        }

        System.out.println("Liste de tout les personnes");
        List<Personnage> allPersonnageByCriteriaBuilder = repo.getAllCharacterWithCriteria();
        for(Personnage myPerso : allPersonnageByCriteriaBuilder){
            System.out.println(myPerso.toString());
        }

        System.out.println("Liste de tout les armes par niveau minimum de pouvoir");
        List<Equipement> allEquipmentByPower = repo.getAllEquipmentWithCriteriaAndMinPower(1);
        for(Equipement equip : allEquipmentByPower){
            System.out.println(equip.toString());
        }

        Personnage personnageFetched = repo.findByNameWithJoin("Arthas3");
        System.out.println("Personnage Fetched : " + (personnageFetched != null ?personnageFetched.toString(): 0));

    }
}