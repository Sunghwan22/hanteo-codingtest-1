package com.hanteo.codingtest.models;

import com.hanteo.codingtest.dtos.BoardDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private Long memberCategoryId;

    public Board() {
    }

    public Board(Long id, Long memberCategoryId) {
        this.id = id;
        this.memberCategoryId = memberCategoryId;
    }

    public BoardDto toDto() {
        return new BoardDto(id, memberCategoryId);
    }
}
