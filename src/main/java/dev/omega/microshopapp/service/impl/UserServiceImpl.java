package dev.omega.microshopapp.service.impl;

import dev.omega.microshopapp.model.dto.UserDto;
import dev.omega.microshopapp.model.entity.RoleEntity;
import dev.omega.microshopapp.model.entity.User;
import dev.omega.microshopapp.model.enums.UserEnum;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.repository.RoleRepository;
import dev.omega.microshopapp.repository.UserRepository;
import dev.omega.microshopapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public ResponseEntity<String> login(UserDto.UserLoginDto userLoginDto) {
        log.info("In service, Login account with username: {}", userLoginDto.getUsername());
        if (userRepository.findByUsername(userLoginDto.getUsername()).isEmpty()) {
            return ResponseEntity.badRequest().body("Username or password is incorrect");
        }
        return ResponseEntity.ok("Login success");
    }

    @Override
    public ResponseEntity<String> register(UserDto.UserRegisterDto userRegisterDto) {
        log.info("In service, Register account with username: {}", userRegisterDto.getUsername());
        try {
            User user = User.builder()
                    .roles(userRegisterDto.getRoles().stream()
                            .map(userRole -> roleRepository.findByRole(UserEnum.UserRole.valueOf(userRole.name()))
                                    .orElseThrow(RuntimeException::new))
                            .collect(Collectors.toSet()))
                    .username(userRegisterDto.getUsername())
                    .password(userRegisterDto.getPassword())
                    .email(userRegisterDto.getEmail())
                    .fullName(userRegisterDto.getFullName())
                    .gender(userRegisterDto.getGender())
                    .build();
            userRepository.save(user);
            return ResponseEntity.ok("Register success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> update(UserDto.UserUpdateDto userUpdateDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(String username) {
        return null;
    }

    @Override
    public ResponseEntity<UserDto.UserDetailDto> detail(String username) {
        return null;
    }

    @Override
    public ResponseEntity<String> logout() {
        return null;
    }

    @Override
    public ResponseEntity<ResultResList<UserDto.UserSearch>> doSearch(UserDto.UserSearch userSearch) {
        return null;
    }

    @Override
    public ResponseEntity<String> resetPassword(String username) {
        return null;
    }

    @Override
    public ResponseEntity<String> updatePassword(UserDto.UserUpdatePasswordDto userUpdatePasswordDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateStatus(String username, UserEnum.UserStatus status) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateRole(String username, UserEnum.UserRole role) {
        return null;
    }

    @Override
    public ResponseEntity<String> creatRole(UserEnum.UserRole roleName) {
        try {
            log.info("In service, Create role with name: {}", roleName);
            if (roleRepository.findByRole(roleName).isPresent()) {
                return ResponseEntity.badRequest().body("Role already exists");
            }
            roleRepository.save(RoleEntity.builder().role(roleName).build());
            return ResponseEntity.ok("Create role success");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
