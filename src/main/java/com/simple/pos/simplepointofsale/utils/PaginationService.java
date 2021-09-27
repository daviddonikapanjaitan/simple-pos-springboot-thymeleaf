package com.simple.pos.simplepointofsale.utils;

import com.simple.pos.simplepointofsale.Dto.PaginationDto;
import com.simple.pos.simplepointofsale.Dto.PaginationRequestDto;

public interface PaginationService{
    
    PaginationDto paginationService(
        PaginationRequestDto paginationRequestDto
    );
}
