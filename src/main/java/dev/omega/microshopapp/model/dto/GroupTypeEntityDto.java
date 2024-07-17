package dev.omega.microshopapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.GroupTypeEntity}
 */

public class GroupTypeEntityDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddOrEditReq {
        private Long id;
        private String name;
        private String code;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailRes {
        private Long id;
        private String name;
        private String code;
        private Long noOfType;
        private String description;
        private List<ProductTypeEntityDto.LightRes> productTypes;
        private Date createdAt;
        private Date updatedAt;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LightRes {
        private Long id;
        private String name;
    }

    public interface SearchRes {
        Long getId();
        String getName();
        String getCode();
        Long getTotalType();
        String getImage();
        Date getCreatedAt();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchReq extends BaseDTO {
        private String code;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date startDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date endDate;
        private Long noOfType;
    }
}