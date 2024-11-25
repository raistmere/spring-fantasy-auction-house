package com.raistmere.fantasyauctionhouse.bootstrap;

import com.raistmere.fantasyauctionhouse.domains.InventoryItem;
import com.raistmere.fantasyauctionhouse.domains.Item;
import com.raistmere.fantasyauctionhouse.repos.InventoryItemRepository;
import com.raistmere.fantasyauctionhouse.repos.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public BootStrapData(ItemRepository itemRepository, InventoryItemRepository inventoryItemRepository) {
        this.itemRepository = itemRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Item swordItem = new Item();
        swordItem.setItemName("Sword");
        itemRepository.save(swordItem);

        Item potionItem = new Item();
        potionItem.setItemName("Health Potion");
        itemRepository.save(potionItem);

        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setItem(swordItem);
        inventoryItemRepository.save(inventoryItem);

        InventoryItem inventoryItem2 = new InventoryItem();
        inventoryItem2.setItem(swordItem);
        inventoryItemRepository.save(inventoryItem2);
    }
}
