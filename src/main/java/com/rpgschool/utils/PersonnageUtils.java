package com.rpgschool.utils;

import com.rpgschool.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonnageUtils {



    // on veut faire une factory de la création de personnage
    public Personnage getRandomPersonnage(String personnageNom) {


           Random r = new Random();
           Personnage p = new Personnage();
           p.setNom(personnageNom);
           p.setNiveau(r.nextInt(50));
           p.setExperience(2500);

           Type_Personnage[] valeurs = Type_Personnage.values();

           Type_Personnage type = valeurs[r.nextInt(valeurs.length)];

           p.setType(type);

           TypeEquipement[] valeurEquipement = TypeEquipement.values();
           TypeEquipement equipeType = valeurEquipement[r.nextInt(valeurEquipement.length)];
           Equipement equipement = new Equipement();
           equipement.setNom("hache");
           equipement.setType(equipeType);
           equipement.setPersonnage(p);


           equipement.setPuissance(r.nextInt(1000));
           equipement.setSpecificite(type);
           List<Equipement> equipements = new ArrayList<Equipement>();
           equipements.add(equipement);
           p.setEquipement(equipements);

           Competence competence = new Competence();
           competence.setNom("Holy grenade");
           competence.setDescription("Holy grenade");
           competence.setCoutMana(r.nextInt(25));
           competence.setNiveauRequis(r.nextInt(25));

           p.addCompetence(competence);


           return p;


    }
    public List<Personnage> generateListPersonnage() {
        List<String> personnageNom = new ArrayList<>();
        personnageNom.add("Arthas");
        personnageNom.add("Leonidas");
        personnageNom.add("Luffy");
        personnageNom.add("Naruto");
        personnageNom.add("Zoro");
        personnageNom.add("Pikachu");

        List<Personnage> listPerso = new ArrayList<>();

        for (int i = 0; i < personnageNom.size(); i++) {
            Personnage p = getRandomPersonnage(personnageNom.get(i));
            listPerso.add(p);
        }

        return listPerso;
    }

}
