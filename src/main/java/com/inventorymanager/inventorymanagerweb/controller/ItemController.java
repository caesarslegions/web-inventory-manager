package com.inventorymanager.inventorymanagerweb.controller;

import com.inventorymanager.inventorymanagerweb.model.Item;
import com.inventorymanager.inventorymanagerweb.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/items")
public class ItemController {

        private final ItemService itemService;

        public ItemController(ItemService itemService) { this.itemService = itemService; }

        @GetMapping
        public ResponseEntity<List<Item>> getAllItems() {
            return ResponseEntity.ok(itemService.getAllItems());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Item> getItemById(@PathVariable int id) {
            return ResponseEntity.ok(itemService.getItemById(id));
        }

        @PostMapping
        public ResponseEntity<Item> createItem(@RequestBody Item item) {
            return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item) {
            return ResponseEntity.ok(itemService.updateItem(item));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteItem(@PathVariable int id) {
            itemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}
