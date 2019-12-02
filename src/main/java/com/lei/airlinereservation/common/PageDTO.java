package com.lei.airlinereservation.common;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
@Data
public class PageDTO<T> {
    private Long totalElement;
    private Integer totalPage;
    private Integer currentPageNumber;
    private Integer pageSize;
    private Boolean hasPrevious;
    private Boolean hasNext;
    List<T> content;

    public PageDTO(Page<T> page) {
        totalElement = page.getTotalElements();
        totalPage = page.getTotalPages();
        currentPageNumber = page.getNumber() + 1;
        pageSize = page.getSize();
        hasPrevious = page.hasPrevious();
        hasNext = page.hasNext();
        content = page.getContent();

    }
}
