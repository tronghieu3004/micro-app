package dev.omega.microshopapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductTypeEntity extends BaseEntity {
    private String name;
    private String code;
    private String description;
    private String image;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "productType",
            cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductEntity> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_type_id")
    private GroupTypeEntity groupType;
}