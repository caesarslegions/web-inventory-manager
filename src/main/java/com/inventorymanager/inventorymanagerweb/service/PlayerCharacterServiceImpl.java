package com.inventorymanager.inventorymanagerweb.service;

import com.inventorymanager.inventorymanagerweb.dao.PlayerCharacterDao;
import com.inventorymanager.inventorymanagerweb.model.PlayerCharacter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerCharacterServiceImpl implements PlayerCharacterService {

    private final PlayerCharacterDao playerCharacterDao;

    public PlayerCharacterServiceImpl(PlayerCharacterDao playerCharacterDao) {
        this.playerCharacterDao = playerCharacterDao;
    }

    @Override
    public List<PlayerCharacter> getAllPlayerCharacters() {
        return playerCharacterDao.getAllPlayerCharacters();
    }

    @Override
    public PlayerCharacter getPlayerCharacterById(int id) {
        return playerCharacterDao.getPlayerCharacter(id);
    }

    @Override
    public PlayerCharacter createPlayerCharacter(PlayerCharacter playerCharacter) {
        return playerCharacterDao.createPlayerCharacter(playerCharacter);
    }

    @Override
    public PlayerCharacter updatePlayerCharacter(PlayerCharacter playerCharacter) {
        if (playerCharacterDao.updatePlayerCharacter(playerCharacter)) {
            return playerCharacter;
        } else {
            throw new RuntimeException("Unable to update player character");
        }
    }

    @Override
    public void deletePlayerCharacter(int id) {
        playerCharacterDao.deletePlayerCharacter(id);
    }
}
