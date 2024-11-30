package com.raistmere.fantasyauctionhouse.services;

import com.raistmere.fantasyauctionhouse.domains.Auction;

import java.util.List;

public interface AuctionService {

    public List<Auction> findAllAuctions();
    public Auction findAuctionById(Long id);
    public void saveAuction(Auction auction);
}
