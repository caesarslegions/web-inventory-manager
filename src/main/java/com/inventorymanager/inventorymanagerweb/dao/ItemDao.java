package com.inventorymanager.inventorymanagerweb.dao;

import com.inventorymanager.inventorymanagerweb.model.Item;

import java.util.List;

public interface ItemDao {

    List<Item> getAllItems();

    Item getItem(int itemId);

    List<Item> getItemsByCharacterId(int characterId);

    Item createItem(Item item);

    boolean updateItem(Item item);

    void deleteItem(int itemId);
}
