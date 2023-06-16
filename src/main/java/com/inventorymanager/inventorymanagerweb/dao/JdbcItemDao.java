package com.inventorymanager.inventorymanagerweb.dao;

import com.inventorymanager.inventorymanagerweb.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcItemDao implements ItemDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM item ORDER BY item_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Item item = mapRowToItem(results);
            items.add(item);
        }
        return items;
    }

    @Override
    public Item getItem(int itemId) {
        Item item = null;
        String sql = "SELECT * FROM item WHERE item_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itemId);
        if (results.next()) {
            item = mapRowToItem(results);
        }
        return item;
    }

    @Override
    public List<Item> getItemsByCharacterId(int characterId) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM item JOIN character_item ON item.item_id = character_item.item_id WHERE character_item.character_id = ? ORDER BY item.item_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, characterId);
        while (results.next()) {
            Item item = mapRowToItem(results);
            items.add(item);
        }
        return items;

    }

    @Override
    public Item createItem(Item item) {
        String sql = "INSERT INTO item (item_name, item_description, item_effect, item_value) VALUES (?, ?, ?, ?) RETURNING item_id;";
        int itemId = jdbcTemplate.queryForObject(sql, Integer.class, item.getItemName(), item.getItemDescription(), item.getItemEffect(), item.getItemValue());
        item.setItemId(itemId);
        return item;
    }

    @Override
    public boolean updateItem(Item item) {
        String sql = "UPDATE item SET item_name = ?, item_description = ?, item_effect = ?, item_value = ? WHERE item_id = ?;";
        return jdbcTemplate.update(sql, item.getItemName(), item.getItemDescription(), item.getItemEffect(), item.getItemValue(), item.getItemId()) > 0;
    }

    @Override
    public void deleteItem(int itemId) {
        String sql = "DELETE FROM item WHERE item_id = ?;";
        jdbcTemplate.update(sql, itemId);
    }

    private Item mapRowToItem(SqlRowSet results) {
        Item item = new Item();
        item.setItemId(results.getInt("item_id"));
        item.setItemName(results.getString("item_name"));
        item.setItemDescription(results.getString("item_description"));
        item.setItemEffect(results.getString("item_effect"));
        item.setItemValue(results.getDouble("item_value"));
        return item;
    }
}
