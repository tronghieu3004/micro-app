package dev.omega.microshopapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    private Double total;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}