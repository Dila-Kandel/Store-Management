package com.allinone.storemanagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    /**
     * Unique id for the inventory.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     * The product this inventory is of.
     */
    @JsonIgnore
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;
    /**
     * The quantity in stock.
     */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * The item image path.
     */
    @Column(name = "imagePath", nullable = false)
    private String imagePath;
}