package com.allinone.storemanagement.Entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
@Table(name = "web_order_quantities")
public class WebOrderQuantities{

    /**
     * The unqiue id of the order quantity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     * The product being ordered.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    /**
     * The quantity being ordered.
     */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    /**
     * The order itself.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private WebOrder order;
}