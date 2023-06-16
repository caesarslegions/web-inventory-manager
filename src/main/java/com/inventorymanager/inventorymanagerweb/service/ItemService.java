package com.inventorymanager.inventorymanagerweb.service;

import com.inventorymanager.inventorymanagerweb.model.Item;
import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(int id);
    Item createItem(Item item);
    Item updateItem(Item item);
    void deleteItem(int id);
}
