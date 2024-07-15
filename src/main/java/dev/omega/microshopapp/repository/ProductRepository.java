package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select concat('OC -',count(p.id))  " +
            "from ProductEntity p")
    String findNextCode();

    Page<ProductEntity> findByNameContaining(String name, Pageable pageable);

}