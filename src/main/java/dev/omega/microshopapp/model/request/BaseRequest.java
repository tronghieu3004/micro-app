package dev.omega.microshopapp.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class BaseRequest implements Serializable {
    String keyword;
    int pageNo = 1;
    Integer pageSize = 10;
    Sort sort = Sort.by("id").descending();
    public Pageable getPageable() {
        return PageRequest.ofSize(pageSize)
                .withPage(pageNo)
                .withSort(sort);
    }
}
