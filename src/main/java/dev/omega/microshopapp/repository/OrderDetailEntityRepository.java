package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.dto.OrderDetailEntityDto;
import dev.omega.microshopapp.model.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailEntityRepository extends JpaRepository<OrderDetailEntity, Long> {





    @Query("SELECT new dev.omega.microshopapp.model.dto.OrderDetailEntityDto.LightRes(" +
            "e.id, " +
            "e.product.id, " +
            "p.name, " +
            "p.price, " +
            "e.quantity," +
            "cast (p.price * e.quantity as bigdecimal ) )" +
            "FROM OrderDetailEntity e " +
            "JOIN ProductEntity p ON e.product.id = p.id " +
            "WHERE (:orderId is null or e.order.id = :orderId)")
    List<OrderDetailEntityDto.LightRes> findLigthResByOrderId(Long orderId);
}