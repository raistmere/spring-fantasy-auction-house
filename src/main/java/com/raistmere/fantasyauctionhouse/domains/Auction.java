package com.raistmere.fantasyauctionhouse.domains;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Auctions")
public class Auction {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "fk_item_id")
    public Item auctionItem;

    public int auctionPrice;

    public Auction() {}

    public Auction(Item auctionItem, int auctionPrice) {
        this.auctionItem = auctionItem;
        this.auctionPrice = auctionPrice;
    }

    public Long getId() {
        return id;
    }

    public Item getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(Item auctionItem) {
        this.auctionItem = auctionItem;
    }

    public int getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(int auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Auction auction = (Auction) o;
        return auctionPrice == auction.auctionPrice && Objects.equals(id, auction.id) && Objects.equals(this.auctionItem, auction.auctionItem);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(auctionItem);
        result = 31 * result + auctionPrice;
        return result;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", auctionItem=" + auctionItem +
                ", auctionPrice=" + auctionPrice +
                '}';
    }
}
