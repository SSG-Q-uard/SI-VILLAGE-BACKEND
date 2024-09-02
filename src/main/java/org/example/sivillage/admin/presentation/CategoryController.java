package org.example.sivillage.admin.presentation;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.sivillage.admin.application.CategoryService;
import org.example.sivillage.admin.dto.in.AddBottomCategoryRequestDto;
import org.example.sivillage.admin.dto.in.AddMiddleCategoryRequestDto;
import org.example.sivillage.admin.dto.in.AddSubCategoryRequestDto;
import org.example.sivillage.admin.dto.in.TopCategoryRequestDto;
import org.example.sivillage.admin.dto.out.*;
import org.example.sivillage.admin.vo.*;
import org.example.sivillage.global.common.response.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper mapper;

    @Operation(summary = "대 카테고리 생성")
    @PostMapping("/top-categories")
    public BaseResponse<Void> addTopCategory(
            @RequestBody TopCategoryRequestVo topCategoryRequestVo) {

        TopCategoryRequestDto topCategoryRequestDto = TopCategoryRequestDto.builder()
                .topCategoryName(topCategoryRequestVo.getTopCategoryName())
                .topCategoryDescription(topCategoryRequestVo.getTopCategoryDescription())
                .build();

        categoryService.addTopCategory(topCategoryRequestDto);

        return new BaseResponse<>();
    }

    @Operation(summary = "대 카테고리 리스트 조회")
    @GetMapping("/top-category")
    public BaseResponse<GetTopCategoriesResponseVo> getTopCategory() {

        GetTopCategoriesResponseDto responseDto = categoryService.getTopCategories();
        GetTopCategoriesResponseVo response = mapper.map(responseDto, GetTopCategoriesResponseVo.class);

        return new BaseResponse<>(response);
    }

    @Operation(summary = "중 카테고리 생성")
    @PostMapping("/middle-categories")
    public BaseResponse<Void> addMiddleCategory(
            @RequestBody AddMiddleCategoryRequestVo addMiddleCategoryRequestVo) {
        AddMiddleCategoryRequestDto request = mapper.map(addMiddleCategoryRequestVo, AddMiddleCategoryRequestDto.class);
        categoryService.addMiddleCategory(request);

        return new BaseResponse<>();
    }

    @Operation(summary = "중 카테고리 리스트 조회")
    @GetMapping("/middle-category/{topCategoryCode}")
    public BaseResponse<GetMiddleCategoriesResponseVo> getMiddleCategories(
            @PathVariable String topCategoryCode) {

        GetMiddleCategoriesResponseDto responseDto = categoryService.getMiddleCategories(topCategoryCode);
        GetMiddleCategoriesResponseVo response = mapper.map(responseDto, GetMiddleCategoriesResponseVo.class);

        return new BaseResponse<>(response);
    }

    @Operation(summary = "소 카테고리 리스트 생성")
    @PostMapping("/bottom-category")
    public BaseResponse<Void> addBottomCategory(
            @RequestBody AddBottomCategoryRequestVo addBottomCategoryRequestVo) {
        AddBottomCategoryRequestDto request = mapper.map(addBottomCategoryRequestVo, AddBottomCategoryRequestDto.class);
        categoryService.addBottomCategory(request);

        return new BaseResponse<>();
    }

    @Operation(summary = "소 카테고리 조회")
    @GetMapping("/bottom-categories/{middleCategoryCode}")
    public BaseResponse<GetBottomCategoriesResponseVo> getBottomCategories(
            @PathVariable String middleCategoryCode) {

        GetBottomCategoriesResponseDto responseDto = categoryService.getBottomCategory(middleCategoryCode);
        GetBottomCategoriesResponseVo response = mapper.map(responseDto, GetBottomCategoriesResponseVo.class);

        return new BaseResponse<>(response);
    }

    @Operation(summary = "서브 카테고리 생성")
    @PostMapping("/sub-category")
    public BaseResponse<Void> addSubCategory(
            @RequestBody AddSubCategoryRequestVo addSubCategoryRequestVo) {
        AddSubCategoryRequestDto request = mapper.map(addSubCategoryRequestVo, AddSubCategoryRequestDto.class);
        categoryService.addSubCategory(request);

        return new BaseResponse<>();
    }

    @Operation(summary = "서브 카테고리 조회")
    @GetMapping("/sub-category/{subCategoryCode}")
    public BaseResponse<SubCategoryResponseVo> getSubCategory(
            @PathVariable String subCategoryCode) {

        SubCategoryResponseDto responseDto = categoryService.getSubCategory(subCategoryCode);
        SubCategoryResponseVo response = mapper.map(responseDto, SubCategoryResponseVo.class);

        return new BaseResponse<>(response);
    }

}