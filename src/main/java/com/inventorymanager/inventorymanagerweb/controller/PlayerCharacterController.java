package com.inventorymanager.inventorymanagerweb.controller;

import com.inventorymanager.inventorymanagerweb.model.PlayerCharacter;
import com.inventorymanager.inventorymanagerweb.service.PlayerCharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/player-characters")
public class PlayerCharacterController {

    private final PlayerCharacterService playerCharacterService;

    public PlayerCharacterController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerCharacter>> getAllPlayerCharacters() {
        return ResponseEntity.ok(playerCharacterService.getAllPlayerCharacters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerCharacter> getPlayerCharacterById(@PathVariable int id) {
        return ResponseEntity.ok(playerCharacterService.getPlayerCharacterById(id));
    }

    @PostMapping
    public ResponseEntity<PlayerCharacter> createPlayerCharacter(@RequestBody PlayerCharacter playerCharacter) {
        return new ResponseEntity<>(playerCharacterService.createPlayerCharacter(playerCharacter), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerCharacter> updatePlayerCharacter(@PathVariable int id, @RequestBody PlayerCharacter playerCharacter) {
        return ResponseEntity.ok(playerCharacterService.updatePlayerCharacter(playerCharacter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerCharacter(@PathVariable int id) {
        playerCharacterService.deletePlayerCharacter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}