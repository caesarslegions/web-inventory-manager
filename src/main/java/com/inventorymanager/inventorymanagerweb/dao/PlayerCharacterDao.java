package com.inventorymanager.inventorymanagerweb.dao;

import com.inventorymanager.inventorymanagerweb.model.PlayerCharacter;

import java.util.List;

public interface PlayerCharacterDao {

    PlayerCharacter getPlayerCharacter(int PlayerCharacterId);

    List<PlayerCharacter> getAllPlayerCharacters();

    PlayerCharacter createPlayerCharacter(PlayerCharacter PlayerCharacter);

    boolean updatePlayerCharacter(PlayerCharacter PlayerCharacter);

    void deletePlayerCharacter(int PlayerCharacterId);

}
