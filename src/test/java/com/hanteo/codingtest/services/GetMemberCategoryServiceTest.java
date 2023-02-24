package com.hanteo.codingtest.services;

import com.hanteo.codingtest.dtos.MemberCategoryDtos;
import com.hanteo.codingtest.models.Board;
import com.hanteo.codingtest.models.MemberCategory;
import com.hanteo.codingtest.repositories.BoardRepository;
import com.hanteo.codingtest.repositories.MemberCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GetMemberCategoryServiceTest {
    MemberCategoryRepository memberCategoryRepository;
    BoardRepository boardRepository;
    GetMemberCategoryService getMemberCategoryService;

    @BeforeEach
    void setup() {
        memberCategoryRepository = mock(MemberCategoryRepository.class);
        boardRepository = mock(BoardRepository.class);
        getMemberCategoryService = new GetMemberCategoryService(memberCategoryRepository, boardRepository);
    }

    @Test
    void getMemberCategoryWithIdentifier() {
        given(memberCategoryRepository.findById(1L))
            .willReturn(Optional.of(new MemberCategory(1L, 1L, "진")));

        given(boardRepository.findAllByMemberCategoryId(1L))
            .willReturn(List.of(
                new Board(1L, 1L),
                new Board(2L, 1L)
            ));

        MemberCategoryDtos memberCategoryDtos = getMemberCategoryService.list(1L, "");

        assertThat(memberCategoryDtos.getMemberCategory().getCategoryName()).isEqualTo("진");
        assertThat(memberCategoryDtos.getBoards().size()).isEqualTo(2);
    }

    @Test
    void getMemberCategoryWithSearchWord() {
        given(memberCategoryRepository.findByCategoryName("진"))
            .willReturn(new MemberCategory(1L, 1L, "진"));

        given(boardRepository.findAllByMemberCategoryId(1L))
            .willReturn(List.of(
                new Board(1L, 1L),
                new Board(2L, 1L)
            ));

        MemberCategoryDtos memberCategoryDtos = getMemberCategoryService.list(null, "진");

        assertThat(memberCategoryDtos.getMemberCategory().getCategoryName()).isEqualTo("진");
        assertThat(memberCategoryDtos.getBoards().size()).isEqualTo(2);
    }
}