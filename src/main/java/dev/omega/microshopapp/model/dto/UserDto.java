package dev.omega.microshopapp.model.dto;

import dev.omega.microshopapp.model.enums.UserEnum;
import dev.omega.microshopapp.model.request.BaseRequest;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.User}
 */
@Value
public class UserDto implements Serializable {
    public static class UserRegisterDto {
        @Email
        @NotBlank(message = "Email cannot be blank")
        String email;
        @NotNull
        @Size(message = "Length is between 6 and 20 ", min = 6, max = 20)
        @NotBlank(message = "Fullname cannot be blank")
        String fullName;
        @NotNull
        @NotBlank(message = "Username cannot be blank")
        String username;
        @NotNull
        @Size(min = 8, max = 20)
        @NotBlank
        String password;
        @NotNull
        @Enumerated(EnumType.STRING)
        UserEnum.UserGender gender;
    }

    public static class UserUpdateDto {
        @Email
        @NotBlank(message = "Email cannot be blank")
        String email;
        @NotNull
        @Size(message = "Length is betwen 6 and 20 ", min = 6, max = 20)
        @NotBlank(message = "Fullname cannot be blank")
        String fullName;
        @NotNull
        @NotBlank(message = "Username cannot be blank")
        String username;
        @NotNull
        @Size(min = 8, max = 20)
        @NotBlank
        String password;
        @NotNull
        @Enumerated(EnumType.STRING)
        UserEnum.UserGender gender;
        @Pattern(regexp = "(^$|[0-9]{10})")
        @NotBlank(message = "Phone cannot be blank")
        String phone;
        @NotBlank(message = "Address cannot be blank")
        String address;
        @NotBlank
        @Enumerated(EnumType.STRING)
        UserEnum.UserRole role;
    }
    @Getter
    public static class UserLoginDto {
        @NotBlank
        String username;
        @NotBlank
        String password;
    }
    @Getter
    public static class UserUpdatePasswordDto {
        @NotNull
        @NotBlank
        String username;
        @NotBlank
        String oldPassword;
        @NotBlank
        String newPassword;
    }


    public static class UserDetailDto {
        String fullName;
        String username;
        String password;
        String email;
        String phone;
        String address;
        UserEnum.UserRole role;
        UserEnum.UserStatus status;
        UserEnum.UserGender gender;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserReqSearch extends BaseRequest {
        String fullName;
        String username;
        String email;
        String phone;
        UserEnum.UserRole role;
        UserEnum.UserStatus status;
        UserEnum.UserGender gender;
    }

    public interface UserSearch {
        String getFullName();

        String getUsername();

        String getEmail();

        UserEnum.UserGender getGender();

        String getPhone();

        UserEnum.UserRole getRole();

        UserEnum.UserStatus getStatus();
    }
}