package dev.omega.microshopapp.model.entity;

import dev.omega.microshopapp.model.enums.BaseEntity;
import dev.omega.microshopapp.model.enums.UserEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE tbl_user SET is_deleted = 'YES'")
@SQLRestriction("is_deleted = 'NO'")
@Table(name = "tbl_user")
public class User extends BaseEntity implements UserDetails {
    @Getter
    private String fullName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Getter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), foreignKey = @ForeignKey(name = "fk_user_role"))
    private Set<RoleEntity> roles = new HashSet<>();


    @Getter
    private UserEnum.UserStatus status;

    @Getter
    private UserEnum.UserGender gender;

    @Getter
    @Email
    private String email;

    @Getter
    private String phone;

    @Getter
    private String address;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole().name())));
        return List.of(new SimpleGrantedAuthority(authorities.toString()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}