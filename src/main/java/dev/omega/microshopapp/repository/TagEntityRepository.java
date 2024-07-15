package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagEntityRepository extends JpaRepository<TagEntity, Long> {
}
