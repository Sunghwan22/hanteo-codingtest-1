package com.hanteo.codingtest.dtos;

public class BoardDto {
    private Long id;
    private Long memberCategoryId;

    public BoardDto(Long id, Long memberCategoryId) {
        this.id = id;
        this.memberCategoryId = memberCategoryId;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberCategoryId() {
        return memberCategoryId;
    }
}
