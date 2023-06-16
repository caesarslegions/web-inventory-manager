package com.inventorymanager.inventorymanagerweb.service;

import com.inventorymanager.inventorymanagerweb.model.PlayerCharacter;
import java.util.List;

public interface PlayerCharacterService {
    List<PlayerCharacter> getAllPlayerCharacters();
    PlayerCharacter getPlayerCharacterById(int id);
    PlayerCharacter createPlayerCharacter(PlayerCharacter playerCharacter);
    PlayerCharacter updatePlayerCharacter(PlayerCharacter playerCharacter);
    void deletePlayerCharacter(int id);
}
