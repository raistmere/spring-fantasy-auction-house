package com.raistmere.fantasyauctionhouse.services;

import com.raistmere.fantasyauctionhouse.domains.InventoryItem;
import com.raistmere.fantasyauctionhouse.domains.Item;

import java.util.List;

public interface InventoryItemService {

    public List<Item> getInventoryItems();
    public void save(InventoryItem inventoryItem);
}
