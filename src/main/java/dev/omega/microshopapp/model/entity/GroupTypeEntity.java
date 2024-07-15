package dev.omega.microshopapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "group_type")
public class GroupTypeEntity extends BaseEntity {
    private String name;
    private String code;
    private String description;
    private String image;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "groupType")
    private List<ProductTypeEntity> productTypes;
}