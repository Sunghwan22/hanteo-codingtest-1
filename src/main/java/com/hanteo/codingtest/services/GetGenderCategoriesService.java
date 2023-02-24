package com.hanteo.codingtest.services;

import com.hanteo.codingtest.dtos.GenderCategoryDtos;
import com.hanteo.codingtest.dtos.GroupCategoryDto;
import com.hanteo.codingtest.models.GenderCategory;
import com.hanteo.codingtest.models.GroupCategory;
import com.hanteo.codingtest.repositories.GenderCategoryRepository;
import com.hanteo.codingtest.repositories.GroupCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GetGenderCategoriesService {
    private final GenderCategoryRepository genderCategoryRepository;
    private final GroupCategoryRepository groupCategoryRepository;

    public GetGenderCategoriesService(
        GenderCategoryRepository genderCategoryRepository,
        GroupCategoryRepository groupCategoryRepository) {
        this.genderCategoryRepository = genderCategoryRepository;
        this.groupCategoryRepository = groupCategoryRepository;
    }

    public GenderCategoryDtos getList(Long genderCategoryId, String searchWord) {
        if(genderCategoryId != null && searchWord.equals("")) {
            GenderCategory genderCategory = getGenderCategory(genderCategoryId);

            List<GroupCategoryDto> groupCategoryDtos = getGroupCategoryByGenderCategoryId(genderCategory.id());
            return new GenderCategoryDtos(genderCategory.toDto(), groupCategoryDtos);
        }

        if(genderCategoryId == null && !searchWord.isBlank()) {
            GenderCategory genderCategory = genderCategoryRepository.findByCategoryName(searchWord);

            List<GroupCategoryDto> groupCategoryDtos = getGroupCategoryByGenderCategoryId(genderCategory.id());

            return new GenderCategoryDtos(genderCategory.toDto(), groupCategoryDtos);
        }

        return null;
    }

    private List<GroupCategoryDto> getGroupCategoryByGenderCategoryId(Long genderCategoryId) {
        List<GroupCategory> groupCategories =
            groupCategoryRepository.findAllByGenderCategoryId(genderCategoryId);

        return groupCategories.stream().map(
            GroupCategory::toDto).toList();
    }

    private GenderCategory getGenderCategory(Long genderCategoryId) {
        return genderCategoryRepository.findById(genderCategoryId)
            .orElseThrow();
    }
}
