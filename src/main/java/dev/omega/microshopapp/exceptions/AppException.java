package dev.omega.microshopapp.exceptions;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppException extends RuntimeException{
    private String code;
    private String message;
    public AppException( String code) {
        this.code = code;
    }
}
