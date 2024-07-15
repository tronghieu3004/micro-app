package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailEntityRepository extends JpaRepository<OrderDetailEntity, Long> {

}