package com.hanteo.codingtest.controllers;

import com.hanteo.codingtest.dtos.GenderCategoryDtos;
import com.hanteo.codingtest.services.GetGenderCategoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gender-categories")
public class GenderCategoryController {
    private final GetGenderCategoriesService getGenderCategoriesService;

    public GenderCategoryController(GetGenderCategoriesService getGenderCategoriesService) {
        this.getGenderCategoriesService = getGenderCategoriesService;
    }

    @GetMapping()
    public GenderCategoryDtos list(
        @RequestParam(value = "genderCategoryId", required = false) Long genderCategoryId,
        @RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord
    ) {
        return getGenderCategoriesService.getList(genderCategoryId, searchWord);
    }
}
