package com.inventorymanager.inventorymanagerweb.model;

import jakarta.persistence.*;


public class PlayerCharacter {


    private int PlayerCharacterId;
    private String PlayerCharacter_name;
    private String PlayerCharacter_class;
    private int PlayerCharacter_level;
    private String PlayerCharacter_description;

    public PlayerCharacter() {

    }

    public PlayerCharacter(int PlayerCharacterId, String PlayerCharacter_name, String PlayerCharacter_class, int PlayerCharacter_level, String PlayerCharacter_description) {
        this.PlayerCharacterId = PlayerCharacterId;
        this.PlayerCharacter_name = PlayerCharacter_name;
        this.PlayerCharacter_class = PlayerCharacter_class;
        this.PlayerCharacter_level = PlayerCharacter_level;
        this.PlayerCharacter_description = PlayerCharacter_description;
    }

    public int getPlayerCharacterId() {
        return PlayerCharacterId;
    }

    public void setPlayerCharacterId(int PlayerCharacterId) {
        this.PlayerCharacterId = PlayerCharacterId;
    }

    public String getPlayerCharacterName() {
        return PlayerCharacter_name;
    }

    public void setPlayerCharacterName(String PlayerCharacter_name) {
        this.PlayerCharacter_name = PlayerCharacter_name;
    }

    public String getPlayerCharacterClass() {
        return PlayerCharacter_class;
    }

    public void setPlayerCharacterClass(String PlayerCharacter_class) {
        this.PlayerCharacter_class = PlayerCharacter_class;
    }

    public int getPlayerCharacterLevel() {
        return PlayerCharacter_level;
    }

    public void setPlayerCharacterLevel(int PlayerCharacter_level) {
        this.PlayerCharacter_level = PlayerCharacter_level;
    }

    public String getPlayerCharacterDescription() {
        return PlayerCharacter_description;
    }

    public void setPlayerCharacterDescription(String PlayerCharacter_description) {
        this.PlayerCharacter_description = PlayerCharacter_description;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "PlayerCharacterId=" + PlayerCharacterId +
                ", PlayerCharacter_name='" + PlayerCharacter_name + '\'' +
                ", PlayerCharacter_class='" + PlayerCharacter_class + '\'' +
                ", PlayerCharacter_level=" + PlayerCharacter_level +
                ", PlayerCharacter_description='" + PlayerCharacter_description + '\'' +
                '}';
    }

}