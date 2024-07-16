package dev.omega.microshopapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {
    private Long pageNo = 1L;

    private Integer pageSize = 10;

    private Long totalItems = 0L;

    private Integer totalPages = 1;

    public Integer getTotalPages() {
        if (totalItems > 0 && pageSize > 0) {
            long total = totalItems / pageSize;
            return Math.toIntExact(totalItems % pageSize > 0 ? total + 1 : total);
        }

        return totalPages;
    }

}
