package dev.omega.microshopapp.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.ProductTypeEntity}
 */

public class ProductTypeEntityDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddOrEditReq {
        Long id;
        @NotBlank(message = "error.productType.name.notBlank")
        String name;
        @NotBlank(message = "error.productType.code.notBlank")
        String code;
        String description;
        String image;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchReq extends BaseDTO {
        String code;
        String groupTypeCode;
        Long noOfProduct;
    }

    //    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//   public static class SearchRes{
//        Long id;
//        String name;
//        String code;
//        String description;
//        String image;
//        Date createdAt;
//   }
    public interface SearchRes {
        Long getId();

        String getName();

        String getCode();

        String getDescription();

        String getImage();

        Date getCreatedAt();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailRes {
        Long id;
        String name;
        String code;
        String description;
        String image;
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
}