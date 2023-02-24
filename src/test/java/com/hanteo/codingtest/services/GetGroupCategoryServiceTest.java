package com.hanteo.codingtest.services;

import com.hanteo.codingtest.dtos.GroupCategoryDtos;
import com.hanteo.codingtest.models.GroupCategory;
import com.hanteo.codingtest.models.MemberCategory;
import com.hanteo.codingtest.repositories.GroupCategoryRepository;
import com.hanteo.codingtest.repositories.MemberCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetGroupCategoryServiceTest {
    GroupCategoryRepository groupCategoryRepository;
    MemberCategoryRepository memberCategoryRepository;
    GetGroupCategoryService getGroupCategoryService;

    @BeforeEach
    void setup() {
        groupCategoryRepository = mock(GroupCategoryRepository.class);
        memberCategoryRepository = mock(MemberCategoryRepository.class);
        getGroupCategoryService = new GetGroupCategoryService(
            groupCategoryRepository, memberCategoryRepository
        );
    }

    @Test
    void GroupCategoryWithIdentifier() {
        given(groupCategoryRepository.findById(1L))
            .willReturn(Optional.of(new GroupCategory(1L, 1L, "방탄")));

        given(memberCategoryRepository.findAllByGroupId(1L))
            .willReturn(List.of(
                new MemberCategory(1L, 1L, "진"),
                new MemberCategory(2L, 1L, "RM")
            ));

        GroupCategoryDtos groupCategoryDtos = getGroupCategoryService.list(1L, "");

        assertThat(groupCategoryDtos.getGroupCategory().getCategoryName()).isEqualTo("방탄");
        assertThat(groupCategoryDtos.getMemberCategories().size()).isEqualTo(2);
    }

    @Test
    void GroupCategoryWithSearchWord() {
        given(groupCategoryRepository.findByCategoryName("방탄"))
            .willReturn(new GroupCategory(1L, 1L, "방탄"));

        given(memberCategoryRepository.findAllByGroupId(1L))
            .willReturn(List.of(
                new MemberCategory(1L, 1L, "진"),
                new MemberCategory(2L, 1L, "RM")
            ));

        GroupCategoryDtos groupCategoryDtos = getGroupCategoryService.list(null, "방탄");

        assertThat(groupCategoryDtos.getGroupCategory().getCategoryName()).isEqualTo("방탄");
        assertThat(groupCategoryDtos.getMemberCategories().size()).isEqualTo(2);
    }
}