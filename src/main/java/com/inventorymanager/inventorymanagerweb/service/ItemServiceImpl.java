package com.inventorymanager.inventorymanagerweb.service;

import com.inventorymanager.inventorymanagerweb.model.Item;
import com.inventorymanager.inventorymanagerweb.dao.ItemDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemDao itemDao;

    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public Item getItemById(int id) {
        return itemDao.getItem(id);
    }

    @Override
    public Item createItem(Item item) {
        return itemDao.createItem(item);
    }

    @Override
    public Item updateItem(Item item) {
        if (itemDao.updateItem(item)) {
            return item;
        } else {
            throw new RuntimeException("Unable to update item");
        }
    }

    @Override
    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }


}
