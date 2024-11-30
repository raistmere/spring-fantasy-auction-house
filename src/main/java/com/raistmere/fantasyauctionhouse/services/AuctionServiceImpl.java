package com.raistmere.fantasyauctionhouse.services;

import com.raistmere.fantasyauctionhouse.domains.Auction;
import com.raistmere.fantasyauctionhouse.repos.AuctionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;

    public AuctionServiceImpl(AuctionRepository auctionRepository) {

        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Auction> findAllAuctions() {

        return auctionRepository.findAll();
    }

    @Override
    public Auction findAuctionById(Long id) {

        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAuction(Auction auction) {

        auctionRepository.save(auction);
    }
}
