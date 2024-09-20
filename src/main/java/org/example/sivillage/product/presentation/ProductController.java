package org.example.sivillage.product.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.sivillage.global.common.response.BaseResponse;
import org.example.sivillage.product.application.ProductService;
import org.example.sivillage.product.dto.in.ChangeProductRequestDto;
import org.example.sivillage.product.dto.in.CreateProductRequestDto;
import org.example.sivillage.product.vo.in.ChangeProductRequestVo;
import org.example.sivillage.product.vo.in.CreateProductRequestVo;
import org.example.sivillage.product.vo.out.CreateProductResponseVo;
import org.example.sivillage.product.vo.out.GetProductBriefInfoResponseVo;
import org.example.sivillage.product.vo.out.GetProductDetailsResponseVo;
import org.springframework.web.bind.annotation.*;

@Tag(name = "상품 관리 API", description = "상품 관련 API endpoints")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "상품 등록")
    @PostMapping
    public BaseResponse<CreateProductResponseVo> addProduct(@Valid @RequestBody CreateProductRequestVo createProductRequestVo) {

        return new BaseResponse<>(
                productService.addProduct(CreateProductRequestDto.from(createProductRequestVo)).toVo()
        );
    }

    @Operation(summary = "단일 상품에 대한 간략 정보 조회", description = "")
    @GetMapping("/brief/{productCode}")
    public BaseResponse<GetProductBriefInfoResponseVo> getProductBriefInfo(@PathVariable String productCode) {

        return new BaseResponse<>(
                productService.getProductBriefInfo(productCode).toVo()
        );
    }

    @Operation(summary = "상품 상세 정보 조회", description = "")
    @GetMapping("/details/{productCode}")
    public BaseResponse<GetProductDetailsResponseVo> getProductDetail(@PathVariable String productCode) {

        return new BaseResponse<>(
                productService.getProductDetail(productCode).toVo()
        );
    }

    @Operation(summary = "상품 수정", description = "")
    @PutMapping
    public BaseResponse<Void> changeProduct(@RequestBody ChangeProductRequestVo createProductRequestVo) {
        productService.changeProduct(ChangeProductRequestDto.from(createProductRequestVo));
        return new BaseResponse<>();
    }


//    @PostMapping(value = "/from-csv", consumes = "multipart/form-data")
//    public BaseResponse<Void> addProductsFromCsv(@RequestParam("file") MultipartFile file) {
//        productService.addProductsFromCsv(file);
//        return new BaseResponse<>();
//    }
//    @Operation(summary = "특정 물품의 전체 카테고리 리스트 반환", description = "test용")
//    @GetMapping("/category-path/{productUuid}")
//    public BaseResponse<GetCategoryPathResponseVo> getCategoryPath(@PathVariable String productUuid) {
//        GetCategoryPathResponseDto responseDto = productService.getCategoryPath(productUuid);
//        GetCategoryPathResponseVo response = mapper.map(responseDto, GetCategoryPathResponseVo.class);
//        return new BaseResponse<>(response);
//    }

}
