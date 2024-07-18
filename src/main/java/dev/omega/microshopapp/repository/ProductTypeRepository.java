package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.dto.ProductTypeEntityDto;
import dev.omega.microshopapp.model.entity.ProductTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Long> {

    @Query("SELECT e.id, " +
            "e.name as name, " +
            "e.code as code," +
            "e.description as description, " +
            "e.image as image, " +
            "e.createdDate as createdAt " +
            "FROM ProductTypeEntity e " +
            "WHERE e.code = ?1 ")
    Page<ProductTypeEntityDto.SearchRes> doSearch(String code, String groupTypeCode, Long noOfProduct, Pageable pageable);

    @Query("SELECT new dev.omega.microshopapp.model.dto.ProductTypeEntityDto.LightRes(e.id, e.name) " +
            "FROM ProductTypeEntity e " +
            "ORDER BY e.id")
    List<ProductTypeEntityDto.LightRes> findAllLightRes();

    Optional<ProductTypeEntity> findByCode(String code);
}