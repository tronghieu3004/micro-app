package dev.omega.microshopapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tag")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity extends BaseEntity {
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    @JoinTable(name = "product_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;
}
