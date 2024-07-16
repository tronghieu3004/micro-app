package dev.omega.microshopapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    private String code;
    private String name;
    private String description;
    private String image;
    private String price;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "products")
    @JoinTable(name = "product_tag",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id")
    private ProductTypeEntity productType;

}