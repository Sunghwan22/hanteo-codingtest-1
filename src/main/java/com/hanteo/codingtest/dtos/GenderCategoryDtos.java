package com.hanteo.codingtest.dtos;

import com.hanteo.codingtest.models.GenderCategory;

import java.util.List;

public class GenderCategoryDtos {
    private GenderCategoryDto genderCategory;
    private List<GroupCategoryDto> groupCategoryDtos;

    public GenderCategoryDtos(
        GenderCategoryDto genderCategory, List<GroupCategoryDto> groupCategoryDtos) {
        this.genderCategory = genderCategory;
        this.groupCategoryDtos = groupCategoryDtos;
    }

    public GenderCategoryDto getGenderCategory() {
        return genderCategory;
    }

    public List<GroupCategoryDto> getGroupCategories() {
        return groupCategoryDtos;
    }
}
