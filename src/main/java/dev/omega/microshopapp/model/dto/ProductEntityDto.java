package dev.omega.microshopapp.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.ProductEntity}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductEntityDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddOrEditReq implements Serializable {
        private String name;
        private String description;
        private String image;
        private double price;
        private int quantity;
        private ProductTypeEntityDto.LightRes productType;
        private List<TagEntityDto.LightRes> tags;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailRes implements Serializable {
        private Long id;
        private String name;
        private String description;
        private String image;
        private Double price;
        private Integer quantity;
        private ProductTypeEntityDto.LightRes productType;
        private List<TagEntityDto.LightRes> tags;
        private Date createdAt;
        private Date updatedAt;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchRes implements Serializable {
        private Long id;
        private String name;
        private String description;
        private String image;
        private Double price;
        private Integer quantity;
        private ProductTypeEntityDto.LightRes productType;
        private List<TagEntityDto.LightRes> tags;
        private Date createdAt;
    }
}