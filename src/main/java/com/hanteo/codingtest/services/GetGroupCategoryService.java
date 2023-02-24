package com.hanteo.codingtest.services;

import com.hanteo.codingtest.dtos.GroupCategoryDtos;
import com.hanteo.codingtest.dtos.MemberCategoryDto;
import com.hanteo.codingtest.models.GroupCategory;
import com.hanteo.codingtest.models.MemberCategory;
import com.hanteo.codingtest.repositories.GroupCategoryRepository;
import com.hanteo.codingtest.repositories.MemberCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GetGroupCategoryService {
    private final GroupCategoryRepository groupCategoryRepository;
    private final MemberCategoryRepository memberCategoryRepository;

    public GetGroupCategoryService(
        GroupCategoryRepository groupCategoryRepository,
        MemberCategoryRepository memberCategoryRepository) {
        this.groupCategoryRepository = groupCategoryRepository;
        this.memberCategoryRepository = memberCategoryRepository;
    }

    public GroupCategoryDtos list(Long groupCategoryId, String searchWord) {
        if(groupCategoryId != null && searchWord.equals("")) {
            GroupCategory groupCategory = groupCategoryRepository.findById(groupCategoryId)
                .orElseThrow();

            List<MemberCategoryDto> memberCategoryDtos = getMemberCategoryByGroupCategoryId(groupCategory.id());
            return new GroupCategoryDtos(groupCategory.toDto(), memberCategoryDtos);
        }

        if(groupCategoryId == null && !searchWord.isBlank()) {
            GroupCategory groupCategory = groupCategoryRepository.findByCategoryName(searchWord);

            List<MemberCategoryDto> memberCategoryDtos = getMemberCategoryByGroupCategoryId(groupCategory.id());
            return new GroupCategoryDtos(groupCategory.toDto(), memberCategoryDtos);
        }

        return null;
    }

    private List<MemberCategoryDto> getMemberCategoryByGroupCategoryId(Long groupCategoryId) {
        List<MemberCategory> memberCategories =
            memberCategoryRepository.findAllByGroupId(groupCategoryId);

        return memberCategories.stream().map(
            MemberCategory::toDto).toList();
    }
}
