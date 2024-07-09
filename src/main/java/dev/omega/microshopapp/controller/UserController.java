package dev.omega.microshopapp.controller;

import dev.omega.microshopapp.model.dto.RoleDTO;
import dev.omega.microshopapp.model.dto.UserDto;
import dev.omega.microshopapp.model.enums.UserEnum;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;
// -----------------------------------User--------------------------------------------------------------------------
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserDto.UserLoginDto userLoginDto) {
        log.info("In controller, Login with username: {}, password: {}", userLoginDto.getUsername(), userLoginDto.getPassword());
        return userService.login(userLoginDto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDto.UserRegisterDto userRegisterDto) {
        log.info("In controller, Register account {}", userRegisterDto);
        return userService.register(userRegisterDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto.UserDetailDto> detail(@PathVariable String username) {
        log.info("In controller, Get user detail with username: {}", username);
        return userService.detail(username);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid UserDto.UserUpdateDto userUpdateDto) {
        log.info("In controller, Update user {}", userUpdateDto);
        return userService.update(userUpdateDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        log.info("In controller, Logout");
        return userService.logout();
    }

    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody @Valid UserDto.UserUpdatePasswordDto userUpdatePasswordDto) {
        log.info("In controller, Update password {}", userUpdatePasswordDto);
        return userService.updatePassword(userUpdatePasswordDto);
    }
    @PutMapping("/reset-password/{username}")
    public ResponseEntity<String> resetPassword(@PathVariable String username) {
        log.info("In controller, Reset password for user {}",username);
        return userService.resetPassword(username);
    }


// -----------------------------------Admin--------------------------------------------------------------------------

    @PatchMapping("admin/update-status/{username}")
    public ResponseEntity<String> updateStatus(@PathVariable String username,
                                               @RequestBody UserEnum.UserStatus status) {
        log.info("In controller, Update status for user {} with status {}", username, status);
        return userService.updateStatus(username, status);
    }

    @PatchMapping("admin/update-role/{username}")
    public ResponseEntity<String> updateRole(@PathVariable String username,
                                             @RequestBody UserEnum.UserRole role) {
        log.info("In controller, Update role for user {} with role {}", username, role);
        return userService.updateRole(username, role);
    }

    @DeleteMapping("admin/{username}")
    public ResponseEntity<String> delete(@PathVariable String username) {
        log.info("In controller, Delete user {}", username);
        return userService.delete(username);
    }

    @GetMapping("admin/search")
    public ResponseEntity<ResultResList<UserDto.UserSearch>> doSearch(@ModelAttribute UserDto.UserSearch userSearch) {
        log.info("In controller, Search user {}", userSearch);
        return userService.doSearch(userSearch);
    }
    @PostMapping("admin/role")
    public ResponseEntity<String> createRole(@RequestBody RoleDTO.AddOrEditRoleDto roleDto) {
        log.info("In controller, Create role {}", roleDto.getRoleName());
        return userService.creatRole(roleDto.getRoleName());
    }
}
