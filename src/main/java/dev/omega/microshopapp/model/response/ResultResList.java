package dev.omega.microshopapp.model.response;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultResList<T> extends ResultResponse<List<T>> {
    private Pagination pagination;

    public ResultResList(String code, String message, List<T> data) {
        super(code, message, data);
    }
    public ResultResList(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ResultResList(String code, List<T> data) {
        this.setCode(code);
        this.setData(data);
    }

    public ResultResList(String code, List<T> data, Pagination pagination) {
        this.setCode(code);
        this.setData(data);
        this.pagination = pagination;
    }

}
