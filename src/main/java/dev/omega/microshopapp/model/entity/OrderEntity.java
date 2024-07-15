package dev.omega.microshopapp.model.entity;

import dev.omega.microshopapp.model.enums.OrderEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "order_entity")
public class OrderEntity extends BaseEntity {
    private String code;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String note;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetailEntity orderDetail;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderEnum.Status status = OrderEnum.Status.PENDING;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderEnum.Type type = OrderEnum.Type.ONLINE;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderEnum.Payment payment = OrderEnum.Payment.CASH;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private UserEntity staff;

}