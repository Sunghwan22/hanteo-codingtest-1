package com.hanteo.codingtest.models;

import com.hanteo.codingtest.dtos.GroupCategoryDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GroupCategory {
    @Id
    @GeneratedValue
    private Long id;

    private Long genderCategoryId;

    private String categoryName;

    public GroupCategory() {
    }

    public GroupCategory(Long id, Long genderCategoryId, String categoryName) {
        this.id = id;
        this.genderCategoryId = genderCategoryId;
        this.categoryName = categoryName;
    }

    public GroupCategoryDto toDto() {
        return new GroupCategoryDto(id, genderCategoryId, categoryName);
    }

    public Long id() {
        return id;
    }
}
