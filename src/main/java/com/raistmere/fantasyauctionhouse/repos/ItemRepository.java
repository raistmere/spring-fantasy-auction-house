package com.raistmere.fantasyauctionhouse.repos;

import com.raistmere.fantasyauctionhouse.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
