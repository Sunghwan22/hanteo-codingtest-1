package com.hanteo.codingtest.services;

import com.hanteo.codingtest.dtos.BoardDto;
import com.hanteo.codingtest.dtos.MemberCategoryDtos;
import com.hanteo.codingtest.models.Board;
import com.hanteo.codingtest.models.MemberCategory;
import com.hanteo.codingtest.repositories.BoardRepository;
import com.hanteo.codingtest.repositories.MemberCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GetMemberCategoryService {
    private final MemberCategoryRepository memberCategoryRepository;
    private final BoardRepository boardRepository;

    public GetMemberCategoryService(
        MemberCategoryRepository memberCategoryRepository,
        BoardRepository boardRepository) {
        this.memberCategoryRepository = memberCategoryRepository;
        this.boardRepository = boardRepository;
    }

    public MemberCategoryDtos list(Long memberCategoryId, String searchWord) {
        if(memberCategoryId != null && searchWord.equals("")) {
            MemberCategory memberCategory = memberCategoryRepository.findById(memberCategoryId)
                .orElseThrow();

            List<BoardDto> boardDtos = getBoardsByMemberCategoryId(memberCategory.id());

            return new MemberCategoryDtos(memberCategory.toDto(), boardDtos);
        }

        if(memberCategoryId == null && !searchWord.equals("")) {
            MemberCategory memberCategory = memberCategoryRepository.findByCategoryName(searchWord);

            List<BoardDto> boardDtos = getBoardsByMemberCategoryId(memberCategory.id());

            return new MemberCategoryDtos(memberCategory.toDto(), boardDtos);
        }

        return null;
    }

    private List<BoardDto> getBoardsByMemberCategoryId(Long memberCategoryId) {
        List<Board> boardDtos =
            boardRepository.findAllByMemberCategoryId(memberCategoryId);

        return boardDtos.stream().map(
            Board::toDto).toList();
    }
}
