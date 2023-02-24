package com.hanteo.codingtest.dtos;

import java.util.List;

public class GroupCategoryDtos {
    private GroupCategoryDto groupCategoryDto;
    private List<MemberCategoryDto> memberCategories;

    public GroupCategoryDtos(GroupCategoryDto groupCategoryDto, List<MemberCategoryDto> memberCategories) {
        this.groupCategoryDto = groupCategoryDto;
        this.memberCategories = memberCategories;
    }

    public GroupCategoryDto getGroupCategory() {
        return groupCategoryDto;
    }

    public List<MemberCategoryDto> getMemberCategories() {
        return memberCategories;
    }
}
