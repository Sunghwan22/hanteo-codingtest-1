package com.hanteo.codingtest.repositories;

import com.hanteo.codingtest.models.MemberCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberCategoryRepository extends JpaRepository<MemberCategory, Long> {
    List<MemberCategory> findAllByGroupId(Long groupCategoryId);

    MemberCategory findByCategoryName(String searchWord);
}
