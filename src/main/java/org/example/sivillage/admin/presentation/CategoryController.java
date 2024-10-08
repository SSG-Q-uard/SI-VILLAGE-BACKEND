package org.example.sivillage.admin.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.sivillage.admin.application.CategoryService;
import org.example.sivillage.admin.dto.out.GetSubCategoriesResponseDto;
import org.example.sivillage.admin.vo.in.AddCategoryRequestVo;
import org.example.sivillage.admin.vo.out.GetSubCategoriesResponseVo;
import org.example.sivillage.global.common.response.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "카테고리 관리 API", description = "카테고리 관련 API endpoints")
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "카테고리 생성", description = "parentCategoryCode =\"\"입력시 최상위 카테고리 생성")
    @PostMapping("/admin")
    public BaseResponse<Void> addCategory(
            @RequestBody AddCategoryRequestVo addCategoryRequestVo) {

        categoryService.addCategory(addCategoryRequestVo.toDto());
        return new BaseResponse<>();
    }

    @Operation(summary = "JSON 파일 기반으로 카테고리 생성", tags = {"admin-pre-data"})
    @PostMapping(value = "/admin/json", consumes = "multipart/form-data")
    public BaseResponse<Void> addCategoryFromFile(@RequestPart("file") MultipartFile file) {
        categoryService.addCategoryFromFile(file);
        return new BaseResponse<>();
    }

    @Operation(summary = "하위 카테고리 리스트 조회", description = "parentCategoryCode =\"top\"입력시 최상위 카테고리 리스트 조회", tags = "상품 정보 조회")
    @GetMapping("/sub-categories")
    public BaseResponse<List<GetSubCategoriesResponseVo>> getSubCategories(
            @RequestParam(value = "parentCategoryCode", required = false) String parentCategoryCode) {
        return new BaseResponse<>(
                categoryService.getSubCategories(parentCategoryCode)
                .stream()
                .map(GetSubCategoriesResponseDto::toVo)
                .toList()
        );
    }
}