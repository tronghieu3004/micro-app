package dev.omega.microshopapp.model.response;

import lombok.Getter;

@Getter
public class Paginator {
    private long pageNo = 1L;
    private int pageSize = 10;
    private long totalItems = 0L;
    private long totalPages = 1L;

    private int offset = 1;
    private int limit = 10;

    private void calculate() {

        this.limit = this.pageSize;

        if (totalItems == 0) {
            this.totalPages = 1;
            this.offset = 0;
            return;
        }

        this.totalPages = (long) Math.ceil(this.totalItems / (double) this.pageSize);
        this.offset = (int) (this.pageNo - 1) * this.pageSize;
    }

    public Paginator() {
    }

    public Paginator(long pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.calculate();
    }

    public Paginator(long pageNo, int pageSize, long totalItems) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.calculate();
    }


    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
        this.calculate();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.calculate();
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
        this.calculate();
    }

    public Pagination toPagination() {
        Pagination pagination = new Pagination();
        pagination.setPageNo(this.pageNo);
        pagination.setPageSize(this.pageSize);
        pagination.setTotalItems(this.totalItems);
        pagination.setTotalPages(this.totalPages);
        return pagination;
    }

}
