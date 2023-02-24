package com.hanteo.codingtest.repositories;

import com.hanteo.codingtest.models.GenderCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenderCategoryRepository extends JpaRepository<GenderCategory, Long>, JpaSpecificationExecutor<GenderCategory> {
    GenderCategory findByCategoryName(String categoryName);
}
