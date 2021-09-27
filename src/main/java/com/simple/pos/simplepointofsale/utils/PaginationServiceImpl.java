package com.simple.pos.simplepointofsale.utils;

import com.simple.pos.simplepointofsale.Dto.PaginationDto;
import com.simple.pos.simplepointofsale.Dto.PaginationRequestDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

@Service
public class PaginationServiceImpl implements PaginationService{

    private static Logger logger = LoggerFactory.getLogger(PaginationServiceImpl.class);

    @Override
    public PaginationDto paginationService(
        PaginationRequestDto paginationRequestDto
    ) {
        Pageable pageable = null;
        Integer pageList = 0;
        Integer sizeList = 0;
        Integer nextPageList = 0;
        Integer totalPage = 0;

        String ascDesc = paginationRequestDto.getAscDesc();
        String page = paginationRequestDto.getPage();
        String size = paginationRequestDto.getSize();
        String filtering = paginationRequestDto.getFiltering();
        Integer totalSize = paginationRequestDto.getTotalSize();

        logger.info("size = {}", size);
        logger.info("page = {}", page);
        logger.info("ascDesc = {}", ascDesc);
        logger.info("filtering = {}", filtering);

        if(size.equalsIgnoreCase("size")){
            sizeList = 5;
            size = "";
        }else{
            sizeList = Integer.parseInt(size);
        }

        if(page.equalsIgnoreCase("page")){
            pageList = 0;
            page = "";
        }else{
            pageList = Integer.parseInt(page) - 1;
        }

        if(ascDesc.equalsIgnoreCase("asc")){
            pageable = PageRequest.of(pageList, sizeList, Sort.by("productTypeCode").ascending());
        }else if(ascDesc.equalsIgnoreCase("desc")){
            pageable = PageRequest.of(pageList, sizeList, Sort.by("productTypeCode").descending());
        }else{
            ascDesc = "";
            pageable = PageRequest.of(pageList, sizeList);
        }

        logger.info("Total Size: {}", totalSize);
        if(totalSize % sizeList == 0){
            totalPage = (totalSize / sizeList);
        }else{
            totalPage = (totalSize / sizeList) + 1;
        }
        nextPageList = pageList + 2;

        PaginationDto paginationDto = new PaginationDto(
            pageList,
            sizeList,
            nextPageList,
            totalPage,
            pageable
        );

        if(totalSize % sizeList == 0){
            totalPage = (totalSize / sizeList);
        }else{
            totalPage = (totalSize / sizeList) + 1;
        }
        
        logger.info("Page: " + page);
        logger.info("Page List: " + pageList);
        logger.info("Page Size: " + totalPage);
        logger.info("Next Page List: " + nextPageList);

        return paginationDto;
    }
}