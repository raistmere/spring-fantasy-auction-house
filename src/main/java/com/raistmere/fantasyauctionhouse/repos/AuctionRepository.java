package com.raistmere.fantasyauctionhouse.repos;

import com.raistmere.fantasyauctionhouse.domains.Auction;
import org.springframework.data.repository.ListCrudRepository;

public interface AuctionRepository extends ListCrudRepository<Auction, Long> {
}
