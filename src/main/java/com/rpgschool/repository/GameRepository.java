package com.rpgschool.repository;

import com.rpgschool.entity.Personnage;
import com.rpgschool.entity.Equipement;
import com.rpgschool.entity.TypeEquipement;
import com.rpgschool.entity.Type_Personnage;

import java.util.List;

public interface GameRepository {
    List<Personnage> findAllCharacters();
    List<Personnage> findCharactersByMinLevel(int minLevel);
    List<Equipement> findWeaponsByMinPower(int minPower); // On suppose ici que "puissance" = "bonus"

    List<Personnage> findCharacterByName(String name);

    List<Personnage> findTypePersonnage(Type_Personnage type, int minLevel);

    List<Equipement> findWeaponsByClass(Type_Personnage type,String name);

    List<Personnage> getAllPersonnagesWithEquipment();

    List<Personnage> getAllByTypeEquipment(TypeEquipement equipementType);

    List<Personnage> getAllCharacterWithSpecificWeapon(TypeEquipement equipmentType);

    List<Personnage> getAllCharacterWithCriteria();

    List<Personnage> getAllCharacterWithCriteriaAndMinLevel(int minLevel);

    List<Equipement> getAllEquipmentWithCriteriaAndMinPower(int minPower);
    //return the number of deleted "Personnage"
    int deleteAllByName(String nameToDelete);
}