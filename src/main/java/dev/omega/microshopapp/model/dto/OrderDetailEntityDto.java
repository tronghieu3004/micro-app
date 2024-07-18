package dev.omega.microshopapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link dev.omega.microshopapp.model.entity.OrderDetailEntity}
 */

public class OrderDetailEntityDto {

    public static class AddOrEditReq  {
        Long id;
        Long orderId;
        Long productId;
        int quantity;
    }

    public static class DetailRes {

        Long id;
        Long orderId;
        Long productId;
        int quantity;
    }
    public interface SearchRes {

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LightRes {
        Long id;
        Long productId;
        String productName;
        Double price;
        int quantity;
        Double totalCost;
    }
}