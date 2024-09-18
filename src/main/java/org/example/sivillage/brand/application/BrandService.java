package org.example.sivillage.brand.application;

import org.example.sivillage.brand.dto.in.AddBrandRequestDto;
import org.example.sivillage.brand.dto.out.GetBrandLikeResponseDto;
import org.example.sivillage.brand.dto.out.GetBrandNameResponseDto;
import org.example.sivillage.global.common.response.dto.IdListResponseDto;

import java.util.List;

public interface BrandService {


    /**
     * 1. addBrand 브랜드 생성
     * @param request
     * return void
     */
    void addBrand(AddBrandRequestDto request);

    /**
     * 2. getBrandIdList 브랜드 ID 목록 조회
     * @param memberUuid 회원 UUID
     * return GetBrandIdListResponseDto
     */
    List<IdListResponseDto<Long>> getBrandIdList(String memberUuid);

    /**
     * 3. getBrandInfo 브랜드 정보 조회
     * @param brandId 브랜드 ID
     * return GetBrandNameResponseDto
     */
    GetBrandNameResponseDto getBrandName(Long brandId);


}
