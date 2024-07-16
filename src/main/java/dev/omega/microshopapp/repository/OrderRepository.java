package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByCode(String code);

    @Query("select concat('OC-',count(p),'-',to_char(now(),'YYYYMMDD-HH24MISS') ) " +
            "from OrderEntity p")
    String findNextCode();
}