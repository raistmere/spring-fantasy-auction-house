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

    @Autowired
    public InventoryItemServiceImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    public List<InventoryItem> getInventoryItems() {
        List<InventoryItem> inventoryItems = new ArrayList<>();
        inventoryItems = inventoryItemRepository.findAll();
        for (InventoryItem inventoryItem : inventoryItems) {

            System.out.println(inventoryItem.toString());
        }
        return inventoryItemRepository.findAll();
    }

    @Override
    public InventoryItem getInventoryItem(Long id) {

        return inventoryItemRepository.findById(id).orElse(null);
    }

    @Override
    public void removeInventoryItem(Long id) {

        inventoryItemRepository.deleteById(id);
    }


    @Override
    public void save(InventoryItem inventoryItem) {

        inventoryItemRepository.save(inventoryItem);
    }
}
