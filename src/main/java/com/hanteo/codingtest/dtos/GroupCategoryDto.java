package com.hanteo.codingtest.dtos;

public class GroupCategoryDto {
    private Long id;
    private Long genderCategoryId;
    private String categoryName;

    public GroupCategoryDto(Long id, Long genderCategoryId, String categoryName) {
        this.id = id;
        this.genderCategoryId = genderCategoryId;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public Long getGenderCategoryId() {
        return genderCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
