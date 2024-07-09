package dev.omega.microshopapp.service.impl;

import dev.omega.microshopapp.model.dto.UserDto;
import dev.omega.microshopapp.model.entity.User;
import dev.omega.microshopapp.model.enums.UserEnum;
import dev.omega.microshopapp.model.response.ResultResList;
import dev.omega.microshopapp.repository.UserRepository;
import dev.omega.microshopapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> login(UserDto.UserLoginDto userLoginDto) {
        log.info("In service, Login account with username: {}", userLoginDto.getUsername());
        User user = userRepository.findByUsername(userLoginDto.getUsername())
                .orElseGet(User::new);
        return ResponseEntity.ok("Login success");
    }

    @Override
    public ResponseEntity<String> register(UserDto.UserRegisterDto userRegisterDto) {
        return null;
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
}
