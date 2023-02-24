package com.hanteo.codingtest.controllers;

import com.hanteo.codingtest.dtos.GenderCategoryDtos;
import com.hanteo.codingtest.models.GenderCategory;
import com.hanteo.codingtest.models.GroupCategory;
import com.hanteo.codingtest.repositories.GenderCategoryRepository;
import com.hanteo.codingtest.repositories.GroupCategoryRepository;
import com.hanteo.codingtest.services.GetGenderCategoriesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GenderCategoryController.class)
class GenderCategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetGenderCategoriesService getGenderCategoriesService;

    @MockBean
    private GroupCategoryRepository groupCategoryRepository;

    @MockBean
    private GenderCategoryRepository genderCategoryRepository;


    @Test
    void listWithSearchWord() throws Exception {
        given(genderCategoryRepository.findById(1L))
            .willReturn(Optional.of(new GenderCategory(1L, "남자")));

        given(groupCategoryRepository.findAllByGenderCategoryId(1L))
            .willReturn(List.of(
                new GroupCategory(1L, 1L, "방탄"),
                new GroupCategory(2L, 1L, "빅뱅")
            ));

        mockMvc.perform(MockMvcRequestBuilders.get("/gender-categories")
                .param("searchWord", "빅뱅"))
            .andExpect(status().isOk());

        verify(getGenderCategoriesService).getList(null, "빅뱅");
    }

    @Test
    void listWithIdentifier() throws Exception {
        given(genderCategoryRepository.findById(1L))
            .willReturn(Optional.of(new GenderCategory(1L, "남자")));

        given(groupCategoryRepository.findAllByGenderCategoryId(1L))
            .willReturn(List.of(
                new GroupCategory(1L, 1L, "방탄"),
                new GroupCategory(2L, 1L, "빅뱅")
            ));

        mockMvc.perform(MockMvcRequestBuilders.get("/gender-categories")
                .param("genderCategoryId", "1"))
            .andExpect(status().isOk());

        verify(getGenderCategoriesService).getList(1L, "");
    }
}