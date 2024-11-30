package com.raistmere.fantasyauctionhouse.repos;

import com.raistmere.fantasyauctionhouse.domains.InventoryItem;
import org.springframework.data.repository.CrudRepository;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Long> {
}
