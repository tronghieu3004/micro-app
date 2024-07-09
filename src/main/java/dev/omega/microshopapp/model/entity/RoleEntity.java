package dev.omega.microshopapp.model.entity;

import dev.omega.microshopapp.model.enums.BaseEntity;
import dev.omega.microshopapp.model.enums.UserEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE tbl_user SET is_deleted = 'YES'")
@SQLRestriction("is_deleted = 'NO'")
@Table(name = "tbl_role")
public class RoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserEnum.UserRole role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();
}