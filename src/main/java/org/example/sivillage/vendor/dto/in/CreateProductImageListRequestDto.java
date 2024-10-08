package org.example.sivillage.vendor.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.sivillage.product.vo.in.CreateProductImageListRequestVo;
import org.example.sivillage.vendor.domain.ProductImage;

@Getter
@NoArgsConstructor
public class CreateProductImageListRequestDto {

    private String productCode;

    private String imageUrl;

    private boolean thumbnail;

    @Builder
    public CreateProductImageListRequestDto(String productCode, String imageUrl, boolean thumbnail) {
        this.productCode = productCode;
        this.imageUrl = imageUrl;
        this.thumbnail = thumbnail;
    }

    public ProductImage toEntity() {
        return ProductImage.builder()
                .productCode(productCode)
                .productImageUrl(imageUrl)
                .thumbnail(thumbnail)
                .build();
    }

    public static CreateProductImageListRequestDto from(CreateProductImageListRequestVo createProductImageListRequestVo) {
        return CreateProductImageListRequestDto.builder()
                .productCode(createProductImageListRequestVo.getProductCode())
                .imageUrl(createProductImageListRequestVo.getImageUrl())
                .thumbnail(createProductImageListRequestVo.isThumbnail())
                .build();
    }

    public ProductImage updateEntity(Long id) {
        return ProductImage.builder()
                .id(id)
                .productCode(productCode)
                .productImageUrl(imageUrl)
                .thumbnail(thumbnail)
                .build();
    }
}
