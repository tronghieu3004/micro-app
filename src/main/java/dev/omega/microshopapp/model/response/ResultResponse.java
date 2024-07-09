package dev.omega.microshopapp.model.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse<T> {
    private String code;
    private String message;
    private T data;
}
