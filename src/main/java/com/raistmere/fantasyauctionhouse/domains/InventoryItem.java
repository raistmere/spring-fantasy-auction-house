package com.raistmere.fantasyauctionhouse.domains;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        InventoryItem that = (InventoryItem) o;
        return Objects.equals(id, that.id) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(item);
        return result;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
