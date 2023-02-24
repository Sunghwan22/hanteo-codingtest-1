package com.hanteo.codingtest.models;

import com.hanteo.codingtest.dtos.GenderCategoryDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GenderCategory {
    @Id
    @GeneratedValue
    private Long id;

    private String categoryName;

    public GenderCategory() {
    }

    public GenderCategory(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public GenderCategoryDto toDto() {
        return new GenderCategoryDto(id, categoryName);
    }

    public Long id() {
        return id;
    }
}
