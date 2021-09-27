package com.simple.pos.simplepointofsale.Dto;

public class PaginationRequestDto{
    
    String ascDesc;
    String page;
    String size;
    String filtering;
    Integer totalSize;
    String sortBy;
    
    public String getAscDesc() {
        return ascDesc;
    }
    
    public void setAscDesc(String ascDesc) {
        this.ascDesc = ascDesc;
    }
    
    public String getPage() {
        return page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getFiltering() {
        return filtering;
    }
    
    public void setFiltering(String filtering) {
        this.filtering = filtering;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }
    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public PaginationRequestDto(){

    }

    @Override
    public String toString() {
        return "PaginationRequestDto [ascDesc=" + ascDesc + ", filtering=" + filtering + ", page=" + page + ", size="
                + size + ", sortBy=" + sortBy + ", totalSize=" + totalSize + "]";
    }

    public PaginationRequestDto(String ascDesc, String page, String size, String filtering, Integer totalSize,
            String sortBy) {
        super();
        this.ascDesc = ascDesc;
        this.page = page;
        this.size = size;
        this.filtering = filtering;
        this.totalSize = totalSize;
        this.sortBy = sortBy;
    }
}
