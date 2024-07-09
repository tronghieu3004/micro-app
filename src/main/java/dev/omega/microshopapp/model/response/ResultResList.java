package dev.omega.microshopapp.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ResultResList<T> extends ResultResponse<List<T>> {

    public ResultResList(String code, String message, List<T> data) {
        super(code, message, data);
    }
}
