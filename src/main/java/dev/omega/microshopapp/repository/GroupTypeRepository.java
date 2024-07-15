package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.GroupTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupTypeRepository extends JpaRepository<GroupTypeEntity, Long> {
    List<GroupTypeEntity> findByCode(String name);

}