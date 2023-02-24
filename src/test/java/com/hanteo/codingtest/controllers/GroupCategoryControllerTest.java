package com.hanteo.codingtest.controllers;

import com.hanteo.codingtest.models.GenderCategory;
import com.hanteo.codingtest.models.GroupCategory;
import com.hanteo.codingtest.models.MemberCategory;
import com.hanteo.codingtest.repositories.GroupCategoryRepository;
import com.hanteo.codingtest.repositories.MemberCategoryRepository;
import com.hanteo.codingtest.services.GetGroupCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GroupCategoryController.class)
class GroupCategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroupCategoryRepository groupCategoryRepository;

    @MockBean
    private MemberCategoryRepository memberCategoryRepository;

    @MockBean
    private GetGroupCategoryService getGroupCategoryService;

    @Test
    void groupCategoryWithIdentifier() throws Exception {
        given(groupCategoryRepository.findById(1L))
            .willReturn(Optional.of(new GroupCategory(1L, 1L, "방탄")));

        given(memberCategoryRepository.findAllByGroupId(1L))
            .willReturn(List.of(
                new MemberCategory(1L, 1L, "진"),
                new MemberCategory(2L, 1L, "슈가")
            ));

        mockMvc.perform(MockMvcRequestBuilders.get("/group-categories")
                .param("genderCategoryId", "1"))
            .andExpect(status().isOk());

        verify(getGroupCategoryService).list(1L, "");
    }

    @Test
    void groupCategoryWithSearchWord() throws Exception {
        given(groupCategoryRepository.findByCategoryName("방탄"))
            .willReturn(new GroupCategory(1L, 1L, "방탄"));

        given(memberCategoryRepository.findAllByGroupId(1L))
            .willReturn(List.of(
                new MemberCategory(1L, 1L, "진"),
                new MemberCategory(2L, 1L, "슈가")
            ));

        mockMvc.perform(MockMvcRequestBuilders.get("/group-categories")
                .param("searchWord", "방탄"))
            .andExpect(status().isOk());

        verify(getGroupCategoryService).list(null, "방탄");
    }
}