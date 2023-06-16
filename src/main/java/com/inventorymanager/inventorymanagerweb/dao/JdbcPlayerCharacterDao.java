package com.inventorymanager.inventorymanagerweb.dao;

import com.inventorymanager.inventorymanagerweb.model.PlayerCharacter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcPlayerCharacterDao implements PlayerCharacterDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlayerCharacterDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public PlayerCharacter getPlayerCharacter(int PlayerCharacterId) {

        PlayerCharacter PlayerCharacter = null;
        String sql = "SELECT * FROM PlayerCharacter WHERE PlayerCharacter_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, PlayerCharacterId);
        if (results.next()) {
            PlayerCharacter = mapRowToPlayerCharacter(results);
        }
        return PlayerCharacter;
    }

    @Override
    public List<PlayerCharacter> getAllPlayerCharacters() {

        List<PlayerCharacter> PlayerCharacters = new ArrayList<>();
        String sql = "SELECT * FROM PlayerCharacter ORDER BY PlayerCharacter_name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            PlayerCharacter PlayerCharacter = mapRowToPlayerCharacter(results);
            PlayerCharacters.add(PlayerCharacter);
        }
        return PlayerCharacters;
    }

    @Override
    public PlayerCharacter createPlayerCharacter(PlayerCharacter PlayerCharacter) {
        String sql = "INSERT INTO PlayerCharacter (PlayerCharacter_name, PlayerCharacter_class, PlayerCharacter_level, PlayerCharacter_description) VALUES (?, ?, ?, ?) RETURNING PlayerCharacter_id";
        int charId = jdbcTemplate.queryForObject(sql, Integer.class, PlayerCharacter.getPlayerCharacterName(), PlayerCharacter.getPlayerCharacterClass(), PlayerCharacter.getPlayerCharacterLevel(), PlayerCharacter.getPlayerCharacterDescription());
        PlayerCharacter.setPlayerCharacterId(charId);
        return PlayerCharacter;
    }

    @Override
    public boolean updatePlayerCharacter(PlayerCharacter PlayerCharacter) {
        String sql = "UPDATE PlayerCharacter SET PlayerCharacter_name = ?, PlayerCharacter_class = ?, PlayerCharacter_level = ?, PlayerCharacter_description = ? WHERE PlayerCharacter_id = ?";
        return jdbcTemplate.update(sql, PlayerCharacter.getPlayerCharacterName(), PlayerCharacter.getPlayerCharacterClass(), PlayerCharacter.getPlayerCharacterLevel(), PlayerCharacter.getPlayerCharacterDescription(), PlayerCharacter.getPlayerCharacterId()) > 0;
    }

    @Override
    public void deletePlayerCharacter(int PlayerCharacterId) {
        String sql1 = "DELETE FROM PlayerCharacter_item WHERE PlayerCharacter_id = ?";
        jdbcTemplate.update(sql1, PlayerCharacterId);
        String sql2 = "DELETE FROM PlayerCharacter WHERE PlayerCharacter_id = ?";
        jdbcTemplate.update(sql2, PlayerCharacterId);
    }

    private PlayerCharacter mapRowToPlayerCharacter(SqlRowSet rowSet) {
        PlayerCharacter PlayerCharacter = new PlayerCharacter();
        PlayerCharacter.setPlayerCharacterId(rowSet.getInt("PlayerCharacter_id"));
        PlayerCharacter.setPlayerCharacterName(rowSet.getString("PlayerCharacter_name"));
        PlayerCharacter.setPlayerCharacterClass(rowSet.getString("PlayerCharacter_class"));
        PlayerCharacter.setPlayerCharacterLevel(rowSet.getInt("PlayerCharacter_level"));
        PlayerCharacter.setPlayerCharacterDescription(rowSet.getString("PlayerCharacter_description"));
        return PlayerCharacter;
    }
}