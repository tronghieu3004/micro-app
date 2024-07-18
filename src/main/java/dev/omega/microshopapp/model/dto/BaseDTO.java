package dev.omega.microshopapp.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class BaseDTO {
    Long id;
    Long pageNo;
    Integer pageSize;
    String sortBy;
    String sortDir;
    String keyword;
}
