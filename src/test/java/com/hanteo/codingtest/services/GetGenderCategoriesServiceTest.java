package com.hanteo.codingtest.services;

import com.hanteo.codingtest.dtos.GenderCategoryDtos;
import com.hanteo.codingtest.models.GenderCategory;
import com.hanteo.codingtest.models.GroupCategory;
import com.hanteo.codingtest.repositories.GenderCategoryRepository;
import com.hanteo.codingtest.repositories.GroupCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class GetGenderCategoriesServiceTest {
    GenderCategoryRepository genderCategoryRepository;
    GroupCategoryRepository groupCategoryRepository;
    GetGenderCategoriesService getGenderCategoriesService;

    @BeforeEach
    void setup() {
        genderCategoryRepository = mock(GenderCategoryRepository.class);
        groupCategoryRepository = mock(GroupCategoryRepository.class);
        getGenderCategoriesService =
            new GetGenderCategoriesService(genderCategoryRepository, groupCategoryRepository);
    }

    @Test
    void getGenderCategoryWithGenderCategoryId() {
        given(genderCategoryRepository.findById(1L))
            .willReturn(Optional.of(new GenderCategory(1L, "남자")));

        given(groupCategoryRepository.findAllByGenderCategoryId(1L))
            .willReturn(List.of(
                new GroupCategory(1L, 1L, "방탄"),
                new GroupCategory(2L, 1L, "엑소")
            ));

        GenderCategoryDtos genderCategoryDtos = getGenderCategoriesService.getList(1L, "");

        assertThat(genderCategoryDtos.getGenderCategory().getCategoryName()).isEqualTo("남자");
        assertThat(genderCategoryDtos.getGroupCategories().size()).isEqualTo(2);
    }

    @Test
    void getGenderCategoryWithSearchWord() {
        given(genderCategoryRepository.findByCategoryName("남자"))
            .willReturn(new GenderCategory(1L, "남자"));

        given(groupCategoryRepository.findAllByGenderCategoryId(1L))
            .willReturn(List.of(
                new GroupCategory(1L, 1L, "방탄"),
                new GroupCategory(2L, 1L, "엑소")
            ));

        GenderCategoryDtos genderCategoryDtos = getGenderCategoriesService.getList(null, "남자");

        assertThat(genderCategoryDtos.getGenderCategory().getCategoryName()).isEqualTo("남자");
        assertThat(genderCategoryDtos.getGroupCategories().size()).isEqualTo(2);
    }
}