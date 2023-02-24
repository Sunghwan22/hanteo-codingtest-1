package com.hanteo.codingtest.controllers;

import com.hanteo.codingtest.models.Board;
import com.hanteo.codingtest.models.GroupCategory;
import com.hanteo.codingtest.models.MemberCategory;
import com.hanteo.codingtest.repositories.BoardRepository;
import com.hanteo.codingtest.repositories.MemberCategoryRepository;
import com.hanteo.codingtest.services.GetMemberCategoryService;
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

@WebMvcTest(MemberCategoryController.class)
class MemberCategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberCategoryRepository memberCategoryRepository;

    @MockBean
    private BoardRepository boardRepository;

    @MockBean
    private GetMemberCategoryService getMemberCategoryService;

    @Test
    void getMemberCategoryWithIdentifier() throws Exception {
        given(memberCategoryRepository.findById(1L))
            .willReturn(Optional.of(new MemberCategory(1L, 1L, "진")));

        given(boardRepository.findAllByMemberCategoryId(1L))
            .willReturn(List.of(
                new Board(1L, 1L),
                new Board(2L, 1L)
            ));

        mockMvc.perform(MockMvcRequestBuilders.get("/member-categories")
                .param("memberCategoryId", "1"))
            .andExpect(status().isOk());

        verify(getMemberCategoryService).list(1L, "");
    }

    @Test
    void getMemberCategoryWithSearchWOrd() throws Exception {
        given(memberCategoryRepository.findByCategoryName("진"))
            .willReturn(new MemberCategory(1L, 1L, "진"));

        given(boardRepository.findAllByMemberCategoryId(1L))
            .willReturn(List.of(
                new Board(1L, 1L),
                new Board(2L, 1L)
            ));

        mockMvc.perform(MockMvcRequestBuilders.get("/member-categories")
                .param("searchWord", "진"))
            .andExpect(status().isOk());

        verify(getMemberCategoryService).list(null, "진");
    }
}