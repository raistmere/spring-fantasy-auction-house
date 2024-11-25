package com.raistmere.fantasyauctionhouse.domains;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Inventory")
public class InventoryItem implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_item_id")
    private Item item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
