package com.raistmere.fantasyauctionhouse.domains;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Items")
public class Item implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    public String itemName;

    public Item() {
    }

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;
        return Objects.equals(Id, item.Id) && Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(Id);
        result = 31 * result + Objects.hashCode(itemName);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Id=" + Id +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
