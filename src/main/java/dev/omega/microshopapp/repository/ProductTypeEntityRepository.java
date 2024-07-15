package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeEntityRepository extends JpaRepository<ProductTypeEntity, Long> {
}