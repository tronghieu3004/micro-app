package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.dto.TagEntityDto;
import dev.omega.microshopapp.model.entity.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagEntityRepository extends JpaRepository<TagEntity, Long> {
    Optional<TagEntity> findByNameContaining(String name);

    @Query("SELECT new dev.omega.microshopapp.model.dto.TagEntityDto.LightRes(e.id, e.name) " +
            "FROM TagEntity e " +
            "ORDER BY e.id")
    List<TagEntityDto.LightRes> findAllLightRes();

    @Query("SELECT e.id as id, " +
            "e.name as name, " +
            "e.products.size as noOfProducts," +
            "e.createdDate as createdAt  " +
            "FROM TagEntity e " +
            "WHERE (:keyword is null or e.name ilike concat('%', :keyword, '%')) ")
    Page<TagEntityDto.SearchRes> doSearch(String name, Pageable pageable);

}
