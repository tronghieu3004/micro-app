package dev.omega.microshopapp.model.enums;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
//    String createdBy;
//    String updatedBy;
    @Column(updatable = false)
    @CreatedDate()
    Date createdDate;
    @Column(insertable = false)
    @LastModifiedDate()
    Date updatedDate;

    @Column(name = "is_deleted",length = 3)
    @Enumerated(EnumType.STRING)
    UltilsEnum.IsDeleted isDeleted = UltilsEnum.IsDeleted.NO;
}
