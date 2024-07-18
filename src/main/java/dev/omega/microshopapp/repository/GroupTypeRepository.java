package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.dto.GroupTypeEntityDto;
import dev.omega.microshopapp.model.entity.GroupTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupTypeRepository extends JpaRepository<GroupTypeEntity, Long> {

    Optional<GroupTypeEntity> findByName(String name);
//    List<GroupTypeEntity> findByCode(String name);
    Optional<GroupTypeEntity> findByCode(String code);

    @Query("SELECT new dev.omega.microshopapp.model.dto.GroupTypeEntityDto.LightRes(e.id, e.name) " +
            "FROM GroupTypeEntity e " +
            "ORDER BY e.id")
    List<GroupTypeEntityDto.LightRes> findAllLightRes();

    @Query("SELECT gt.id as id," +
            "gt.code as code," +
            "gt.name as name, " +
            "gt.productTypes.size as noOfType, " +
            "gt.image as image, " +
            "gt.createdDate as createdAt " +
            "FROM GroupTypeEntity gt " +
            "WHERE (:keyword is null or (gt.name ilike concat('%', :keyword, '%') or gt.code ilike concat('%', :keyword, '%'))) ")
    Page<GroupTypeEntityDto.SearchRes> doSearch( String keyword, Pageable pageable);
}