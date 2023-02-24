package com.hanteo.codingtest.dtos;

public class MemberCategoryDto {
    private Long id;
    private Long groupCategoryId;
    private String categoryName;

    public MemberCategoryDto(Long id, Long groupCategoryId, String categoryName) {
        this.id = id;
        this.groupCategoryId = groupCategoryId;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupCategoryId() {
        return groupCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
