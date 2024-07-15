package dev.omega.microshopapp.model.entity;

import dev.omega.microshopapp.model.enums.UserEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    private String fullName;
    private String username;
    private String password;
    private String phone;
    private String address;
    private UserEnum.UserRole role;
    private UserEnum.UserStatus status;
    private UserEnum.UserGender gender;
    private String email;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "staff", cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderEntity> orders;
}