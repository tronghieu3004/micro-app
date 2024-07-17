package dev.omega.microshopapp.model.response;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResList<T> {
    private String code;
    private String message;
    private List<T> data;
    private Pagination pagination;

    public ResultResList(String code, String message, List<T> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

