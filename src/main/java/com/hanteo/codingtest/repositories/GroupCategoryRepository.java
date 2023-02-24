package com.hanteo.codingtest.repositories;

import com.hanteo.codingtest.models.GroupCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupCategoryRepository extends JpaRepository<GroupCategory, Long> {
    List<GroupCategory> findAllByGenderCategoryId(Long genderCategoryId);

    GroupCategory findByCategoryName(String categoryName);
}
