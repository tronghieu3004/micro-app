package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.dto.UserDto;
import dev.omega.microshopapp.model.entity.User;
import dev.omega.microshopapp.model.enums.UserEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsernameAndPassword(String username, String email);
    boolean existsByEmailOrPhoneOrUsername(String email, String phone, String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByPhone(String phone);
    Optional<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByPhoneAndPassword(String phone, String password);
    @Query("select u " +
            "from User u " +
            "where (:role is null or u.role = :role) " +
            "and (:status is null or u.status = :status) " +
            "and (:gender is null or u.gender = :gender) " +
            "and (:fullName is null or u.fullName ilike concat('%', :fullName, '%') ) " +
            "and (:username is null or u.username ilike concat('%', :username, '%') ) " +
            "and (:email is null or u.email ilike concat('%', :email, '%') ) " +
            "and (:phone is null or u.phone ilike concat('%', :phone, '%') ) " +
            "and (:keyword is null or u.username ilike concat('%', :keyword, '%') " +
                                    "or u.email ilike concat('%', :keyword, '%') " +
                                    "or u.phone ilike concat('%', :keyword, '%') " +
                                    "or u.fullName ilike concat('%', :keyword, '%')) ")
    Page<UserDto.UserSearch> doSearch(String keyword,
                                      UserEnum.UserRole role,
                                      UserEnum.UserStatus status,
                                      UserEnum.UserGender gender,
                                      String fullName,
                                      String username,
                                      String email,
                                      String phone,
                                      Pageable pageable);
}