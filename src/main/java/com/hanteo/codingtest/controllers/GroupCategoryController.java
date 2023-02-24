package com.hanteo.codingtest.controllers;

import com.hanteo.codingtest.dtos.GroupCategoryDtos;
import com.hanteo.codingtest.services.GetGroupCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group-categories")
public class GroupCategoryController {
    private final GetGroupCategoryService getGroupCategoryService;

    public GroupCategoryController(GetGroupCategoryService getGroupCategoryService) {
        this.getGroupCategoryService = getGroupCategoryService;
    }

    @GetMapping()
    public GroupCategoryDtos list(
        @RequestParam(value = "genderCategoryId", required = false) Long groupCategoryId,
        @RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord
    ) {
        return getGroupCategoryService.list(groupCategoryId, searchWord);
    }
}
