package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select concat('PR -',count(p.id),'-',to_char(now(),'YYYYMMDD-HH24MISS')) " +
            "from ProductEntity p")
    String findNextCode();

    Optional<ProductEntity> findByCode(String code);

    Page<ProductEntity> findByNameContaining(String name, Pageable pageable);

}