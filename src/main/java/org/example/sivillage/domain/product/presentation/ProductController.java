package org.example.sivillage.domain.product.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.sivillage.domain.product.application.ProductService;
import org.example.sivillage.domain.product.vo.CreateProductRequest;
import org.example.sivillage.global.common.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "물품 관리 API", description = "물품 관련 API endpoints")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "물품 생성", description = """
    
    """)
    @PostMapping("/")
    public ResponseEntity<Response<?>> createProduct(@Valid @RequestBody CreateProductRequest request) {
        productService.createProduct(request);
        return ResponseEntity.ok(new Response<>("물품 생성이 완료되었습니다."));
    }

    @Operation(summary = "물품 상세 정보 조회", description = """
    
    """)
    @GetMapping("/details/{productId}")
    public ResponseEntity<Response<?>> createProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(new Response<>(productService.getProductDetails(productId),
                "물품 상세정보 조회가 완료되었습니다."));
    }
}
