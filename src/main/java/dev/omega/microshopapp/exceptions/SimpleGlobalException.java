package dev.omega.microshopapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleGlobalException extends RuntimeException {
    private String code;
    private String message;

    public SimpleGlobalException(String message) {
        super(message);
    }
}
