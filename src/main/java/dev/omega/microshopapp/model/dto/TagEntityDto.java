package dev.omega.microshopapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.TagEntity}
 */

public class TagEntityDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddOrEditReq {
        Long id;
        String name;
        String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailRes {
        Long id;
        String name;
        String code;
        String description;
        Set<ProductEntityDto.LightRes> products;
        Integer noOfProduct;
        Date createdAt;
        Date updatedAt;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LightRes {
        Long id;
        String name;
    }

    public interface SearchRes {
        Long getId();
        String getName();
        Long getNoOfProduct();
        Date getCreatedAt();;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchReq extends BaseDTO {
        String code;
        Long noOfProduct;
        Date createdAt;
    }
}