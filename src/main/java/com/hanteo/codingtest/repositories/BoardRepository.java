package com.hanteo.codingtest.repositories;

import com.hanteo.codingtest.dtos.BoardDto;
import com.hanteo.codingtest.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByMemberCategoryId(Long memberCategoryId);
}
