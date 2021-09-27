package com.simple.pos.simplepointofsale.Dto;

import org.springframework.data.domain.Pageable;

public class PaginationDto{
 
    Integer pageList;
    Integer sizeList;
    Integer nextPageList;
    Integer totalPage;
    Pageable pageable;
    
    public Integer getPageList() {
        return pageList;
    }
    public void setPageList(Integer pageList) {
        this.pageList = pageList;
    }
    public Integer getSizeList() {
        return sizeList;
    }
    public void setSizeList(Integer sizeList) {
        this.sizeList = sizeList;
    }
    public Integer getNextPageList() {
        return nextPageList;
    }
    public void setNextPageList(Integer nextPageList) {
        this.nextPageList = nextPageList;
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Pageable getPageable() {
        return pageable;
    }
    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
    public PaginationDto(){

    }
    @Override
    public String toString() {
        return "PaginationDto [nextPageList=" + nextPageList + ", pageList=" + pageList + ", pageable=" + pageable
                + ", sizeList=" + sizeList + ", totalPage=" + totalPage + "]";
    }
    public PaginationDto(Integer pageList, Integer sizeList, Integer nextPageList, Integer totalPage,
            Pageable pageable) {
        super();
        this.pageList = pageList;
        this.sizeList = sizeList;
        this.nextPageList = nextPageList;
        this.totalPage = totalPage;
        this.pageable = pageable;
    }
}