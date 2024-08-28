package org.example.sivillage.member.application;

import lombok.RequiredArgsConstructor;
import org.example.sivillage.global.common.response.BaseResponseStatus;
import org.example.sivillage.global.error.BaseException;
import org.example.sivillage.member.domain.Member;
import org.example.sivillage.member.domain.ProductLike;
import org.example.sivillage.member.infrastructure.MemberRepository;
import org.example.sivillage.product.domain.Product;
import org.example.sivillage.product.dto.in.LikeProductRequestDto;
import org.example.sivillage.product.dto.in.UnlikeProductRequestDto;
import org.example.sivillage.product.infrastructure.ProductLikeRepository;
import org.example.sivillage.product.infrastructure.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductLikeService {

    private final ProductLikeRepository productLikeRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;


    @CacheEvict(value = "procductLikes", key = "#product.productCode + '-' + #member.memberUuid")
    public void unlikeProduct(UnlikeProductRequestDto request) {
        Product product = getProduct(request.getProductCode());
        Member member = getMember(request.getMemberUuid());
        productLikeRepository.deleteByProductAndMember(product, member);
    }

    @Cacheable(value = "procductLikes", key = "#product.productCode + '-' + #member.memberUuid")
    public boolean isProductLikedByMember(String productCode, String memberUuid) {
        Product product = getProduct(productCode);
        Member member = getMember(memberUuid);
        return productLikeRepository.existsByProductAndMember(product, member);
    }

    @CachePut(value = "procductLikes", key = "#product.productCode + '-' + #member.memberUuid")
    public void likeProduct(LikeProductRequestDto request) {
        Product product = getProduct(request.getProductCode());
        Member member = getMember(request.getMemberUuid());

        ProductLike productLike = ProductLike.createProductLike(product, member);
        productLikeRepository.save(productLike);
    }

    public long countLikesForProduct(String productCode) {
        Product product = getProduct(productCode);
        return productLikeRepository.countByProduct(product);
    }

    private Product getProduct(String productCode) {
        return productRepository.findByProductCode(productCode)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.PRODUCT_NOT_FOUND));
    }

    private Member getMember(String memberUuid) {
        return memberRepository.findByMemberUuid(memberUuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.MEMBER_NOT_FOUND));
    }

}
