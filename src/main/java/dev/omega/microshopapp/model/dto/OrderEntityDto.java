package dev.omega.microshopapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.OrderEntity}
 */

public class OrderEntityDto {
    public static class AddOrEditReq {
        private Long id;
        private String name;
        private String code;
        private String description;
    }

    public static class DetailRes {
        private Long id;
        private String name;
        private String code;
        private String description;
        private Date createdAt;
        private Date updatedAt;
    }

    public static class LightRes {
        private Long id;
        private String fullName;
        private String code;
        private String totalCost;
    }

    //    public static class SearchRes {
//        private Long id;
//        private String name;
//        private String code;
//        private Long totalCost;
//        private String description;
//        private Date createdAt;
//    }
    public interface SearchRes {
        Long getId();

        String getName();

        String getCode();

        String getPhone();

        String getEmail();

        Long getTotalCost();

        String getDescription();

        Date getCreatedAt();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchReq extends BaseDTO {
        private String code;
        private Double totalCostFrom;
        private Double totalCostTo;
        private Date createDateFrom;
        private Date createDateTo;

    }
}