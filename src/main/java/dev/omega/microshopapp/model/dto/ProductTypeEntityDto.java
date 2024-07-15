package dev.omega.microshopapp.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.ProductTypeEntity}
 */

public class ProductTypeEntityDto  {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
   public static class AddOrEditReq{
        Long id;
        String name;
        String code;
        String description;
        String image;
   }
   public static class SearchReq extends BaseDTO{
        String code;
        String groupTypeCode;
        Long noOfProduct;
   }
   public static class SearchRes{
        Long id;
        String name;
        String code;
        String description;
        String image;
        Date createdAt;
   }
   public static class DetailRes{
        Long id;
        String name;
        String code;
        String description;
        String image;
        Date createdAt;
        Date updatedAt;
   }
   public static class LightRes{
        Long id;
        String name;
   }
}