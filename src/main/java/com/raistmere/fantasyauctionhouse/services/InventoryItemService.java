package com.raistmere.fantasyauctionhouse.services;

import com.raistmere.fantasyauctionhouse.domains.InventoryItem;
import com.raistmere.fantasyauctionhouse.domains.Item;

import java.util.List;

public interface InventoryItemService {

    public List<InventoryItem> getInventoryItems();
    public InventoryItem getInventoryItem(Long id);
    public void removeInventoryItem(Long id);
    public void save(InventoryItem inventoryItem);
}
