package dev.omega.microshopapp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;
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
        private String name;
    }

    public static class SearchRes {
        private Long id;
        private String name;
        private String code;
        private Long totalCost;
        private String description;
        private Date createdAt;
    }

    public static class SearchReq extends BaseDTO {
        private String code;
        private Long totalCostFrom;
        private Long totalCostTo;
        private Date createDateFrom;
        private Date createDateTo;

    }
}