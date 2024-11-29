package com.raistmere.fantasyauctionhouse.services;

import com.raistmere.fantasyauctionhouse.domains.InventoryItem;
import com.raistmere.fantasyauctionhouse.domains.Item;
import com.raistmere.fantasyauctionhouse.repos.InventoryItemRepository;
import com.raistmere.fantasyauctionhouse.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public InventoryItemServiceImpl(InventoryItemRepository inventoryItemRepository, ItemRepository itemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getInventoryItems() {

        List<Item> inventoryItems = new ArrayList<>();

        for(InventoryItem inventoryItem : inventoryItemRepository.findAll()) {

            Item item = itemRepository.findById(inventoryItem.getItem().getId()).orElse(null);

            if(item != null) {

                inventoryItems.add(item);
            }
        }

        return inventoryItems;
    }

    @Override
    public void save(InventoryItem inventoryItem) {

        inventoryItemRepository.save(inventoryItem);
    }
}
