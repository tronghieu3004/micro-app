package dev.omega.microshopapp.model.entity;

import dev.omega.microshopapp.model.enums.BaseEntity;
import dev.omega.microshopapp.model.enums.UserEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE tbl_user SET is_deleted = 'YES'")
@SQLRestriction("is_deleted = 'NO'")
@Table(name = "tbl_user")
public class User extends BaseEntity {

    @Column(nullable = false)
    @NotBlank(message = "Fullname cannot be blank")
    @Max(message = "Fullname cannot be longer than 255 characters", value = 255)
    @Min(message = "Fullname cannot be shorter than 6 characters", value = 6)
    private String fullName;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Username cannot be blank")
    @Max(message = "Username cannot be longer than 255 characters", value = 255)
    @Min(message = "Username cannot be shorter than 6 characters", value = 6)
    private String username;

    @Column(nullable = false)
    @Max(message = "Password cannot be longer than 255 characters", value = 255)
    @Min(message = "Password cannot be shorter than 8 characters", value = 8)
    private String password;

    @Column( nullable = false)
    @ColumnDefault(value = "STAFF")
    @NotBlank(message = "Role cannot be blank")
    private UserEnum.UserRole role;

    @Column( nullable = false)
    @NotBlank(message = "Status cannot be blank")
    private UserEnum.UserStatus status;

    @Column( nullable = false)
    @NotBlank(message = "Gender cannot be blank")
    private UserEnum.UserGender gender;

    @Column( nullable = false)
    @NotBlank(message = "Email cannot be blank")
    @Max(message = "Email cannot be longer than 255 characters", value = 255)
    @Min(message = "Email cannot be shorter than 8 characters", value = 8)
    @Email
    private String email;

    @Column( nullable = false, unique = true)
    @NotBlank(message = "Phone cannot be blank")
    @Max(message = "Phone cannot be longer than 15 characters", value = 15)
    @Min(message = "Phone cannot be shorter than 8 characters", value = 8)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    @Column()
    @NotBlank(message = "Address cannot be blank")
    @Max(message = "Address cannot be longer than 255 characters", value = 255)
    private String address;

}