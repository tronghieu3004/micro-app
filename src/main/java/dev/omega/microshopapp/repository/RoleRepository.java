package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.RoleEntity;
import dev.omega.microshopapp.model.enums.UserEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByRole(UserEnum.UserRole role);
}