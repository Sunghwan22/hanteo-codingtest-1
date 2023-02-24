package com.hanteo.codingtest.dtos;

public class GenderCategoryDto {
    private Long id;
    private String categoryName;

    public GenderCategoryDto() {
    }

    public GenderCategoryDto(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
