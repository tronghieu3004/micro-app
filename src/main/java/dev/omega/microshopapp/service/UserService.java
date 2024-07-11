package dev.omega.microshopapp.service;

import dev.omega.microshopapp.model.dto.UserDto;
import dev.omega.microshopapp.model.enums.UserEnum;
import dev.omega.microshopapp.model.response.ResultResList;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> login(UserDto.UserLoginDto userLoginDto);

    ResponseEntity<String> register(UserDto.UserRegisterDto userRegisterDto);

    ResponseEntity<String> update(UserDto.UserUpdateDto userUpdateDto);

    ResponseEntity<String> delete(String username);

    ResponseEntity<UserDto.UserDetailDto> detail(String username);

    ResponseEntity<String> logout();

    ResponseEntity<ResultResList<UserDto.UserSearch>> doSearch(UserDto.UserSearch userSearch);

    ResponseEntity<String> resetPassword(String username);

    ResponseEntity<String> updatePassword(UserDto.UserUpdatePasswordDto userUpdatePasswordDto);

    ResponseEntity<String> updateStatus(String username, UserEnum.UserStatus status);

    ResponseEntity<String> updateRole(String username, UserEnum.UserRole role);

    ResponseEntity<String> creatRole(UserEnum.UserRole roleName);
}
