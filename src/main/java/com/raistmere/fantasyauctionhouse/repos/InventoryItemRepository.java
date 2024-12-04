package com.raistmere.fantasyauctionhouse.repos;

import com.raistmere.fantasyauctionhouse.domains.InventoryItem;
import org.springframework.data.repository.ListCrudRepository;

public interface InventoryItemRepository extends ListCrudRepository<InventoryItem, Long> {
}
