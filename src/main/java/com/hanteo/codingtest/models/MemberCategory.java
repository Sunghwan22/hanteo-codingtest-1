package com.hanteo.codingtest.models;

import com.hanteo.codingtest.dtos.MemberCategoryDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class MemberCategory {
    @Id
    @GeneratedValue
    private Long id;

    private Long groupCategoryId;

    private String categoryName;

    public MemberCategory() {
    }

    public MemberCategory(Long id, Long groupCategoryId, String categoryName) {
        this.id = id;
        this.groupCategoryId = groupCategoryId;
        this.categoryName = categoryName;
    }

    public MemberCategoryDto toDto() {
        return new MemberCategoryDto(id, groupCategoryId, categoryName);
    }

    public Long id() {
        return id;
    }
}
