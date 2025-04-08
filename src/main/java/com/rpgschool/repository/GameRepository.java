package com.rpgschool.repository;

import com.rpgschool.entity.Personnage;
import com.rpgschool.entity.Equipement;

import java.util.List;

public interface GameRepository {
    List<Personnage> findAllCharacters();
    List<Personnage> findCharactersByMinLevel(int minLevel);
    List<Equipement> findWeaponsByMinPower(int minPower); // On suppose ici que "puissance" = "bonus"

    List<Personnage> findCharacterByName(String name);
}