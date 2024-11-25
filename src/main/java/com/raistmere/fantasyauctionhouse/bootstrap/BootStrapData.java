package com.raistmere.fantasyauctionhouse.bootstrap;

import com.raistmere.fantasyauctionhouse.domains.Item;
import com.raistmere.fantasyauctionhouse.repos.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public BootStrapData(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Item swordItem = new Item();
        swordItem.setItemName("Sword");
        itemRepository.save(swordItem);

        Item potionItem = new Item();
        potionItem.setItemName("Health Potion");
        itemRepository.save(potionItem);

        System.out.println("Number of items: " + itemRepository.count());
        System.out.println(itemRepository.findAll());
    }
}
