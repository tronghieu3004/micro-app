package dev.omega.microshopapp.model.dto;

import dev.omega.microshopapp.model.enums.UserEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class RoleDTO {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddOrEditRoleDto {
        Long id;
        @Enumerated(EnumType.STRING)
        UserEnum.UserRole roleName;
    }
}
