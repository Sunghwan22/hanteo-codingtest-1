package com.hanteo.codingtest.controllers;

import com.hanteo.codingtest.dtos.MemberCategoryDtos;
import com.hanteo.codingtest.services.GetMemberCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member-categories")
public class MemberCategoryController {
    private final GetMemberCategoryService getMemberCategoryService;

    public MemberCategoryController(GetMemberCategoryService getMemberCategoryService) {
        this.getMemberCategoryService = getMemberCategoryService;
    }

    @GetMapping()
    public MemberCategoryDtos list(
        @RequestParam(value = "memberCategoryId", required = false) Long memberCategoryId,
        @RequestParam(value = "searchWord", required = false, defaultValue = "") String searchWord
    ) {
        return getMemberCategoryService.list(memberCategoryId, searchWord);
    }
}
