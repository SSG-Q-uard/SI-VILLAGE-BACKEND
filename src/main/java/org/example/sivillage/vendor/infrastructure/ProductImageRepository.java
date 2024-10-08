package org.example.sivillage.vendor.infrastructure;

import io.lettuce.core.dynamic.annotation.Param;
import org.example.sivillage.vendor.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    Optional<ProductImage> findByProductCodeAndThumbnailTrue(String productCode);

    @Query("SELECT pi.productImageUrl FROM ProductImage pi WHERE pi.productCode = :productCode")
    List<String> findProductImageUrlsByProductCode(@Param("productCode") String productCode);

    ProductImage findByProductCode(String productCode);
}
