package dev.omega.microshopapp.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Getter
@Setter
public class Paginator {

    Long pageNo = 1L;
    Integer pageSize = 10;
    Long totalPage = 0L;
    Long totalItems = 1L;

//    int offset = 1;
//    int limit = 10;

    private void calculateTotalPage() {
        totalPage = (long) Math.ceil((double) totalItems / pageSize);
        if (totalItems % pageSize != 0) {
            totalPage++;
        }
        if (totalItems == 0) {
            totalPage = 1L;
        }
    }
    public Paginator(Long pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.calculateTotalPage();
    }

    public Paginator(Long pageNo, int pageSize, Long totalItems) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.calculateTotalPage();
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
        this.calculateTotalPage();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.calculateTotalPage();
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
        this.calculateTotalPage();
    }

    public Paginator getInfo() {
        return this;
    }
}
