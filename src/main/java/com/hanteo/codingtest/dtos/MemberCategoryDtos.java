package com.hanteo.codingtest.dtos;

import java.util.List;

public class MemberCategoryDtos {
    private MemberCategoryDto memberCategoryDto;
    private List<BoardDto> boardDtos;

    public MemberCategoryDtos(MemberCategoryDto memberCategoryDto, List<BoardDto> boardDtos) {
        this.memberCategoryDto = memberCategoryDto;
        this.boardDtos = boardDtos;
    }

    public MemberCategoryDto getMemberCategory() {
        return memberCategoryDto;
    }

    public List<BoardDto> getBoards() {
        return boardDtos;
    }
}
