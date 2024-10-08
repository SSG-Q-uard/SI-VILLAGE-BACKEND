package org.example.sivillage.vendor.infrastructure;

import org.example.sivillage.vendor.domain.ProductByVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductByVendorRepository extends JpaRepository<ProductByVendor, Long> {
    List<ProductByVendor> findByVendorName(String vendorName);

    Optional<ProductByVendor> findByProductCode(String productCode);

    @Query("SELECT p.discountRate FROM ProductByVendor p WHERE p.productCode = :productCode")
    Optional<Double> findDiscountRateByProductCode(@Param("productCode") String productCode);
}
