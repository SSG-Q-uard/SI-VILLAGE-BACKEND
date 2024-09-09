package org.example.sivillage.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.sivillage.review.domain.Review;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDto {

    private Long reviewId;

    private Double score;

    private String authorEmail;

    private String purchaseOption;

    private String memberInformation;

    private LocalDateTime reviewDate;

    private String reviewContent;

    private Integer reviewLikeCount;

    private List<String> reviewImages;

    public static ReviewResponseDto toDto(Review review, List<String> reviewImages) {
        return ReviewResponseDto.builder()
                .reviewId(review.getReviewId())
                .score(review.getScore())
                .authorEmail(review.getAuthorEmail().substring(0, 4) + "*******") // 이메일 암호화 해서 dto 에 저장
                .memberInformation(review.getMemberInformation())
                .reviewDate(review.getCreatedDate())
                .reviewContent(review.getReviewContent())
                .reviewLikeCount(review.getReviewLikeCount())
                .reviewImages(reviewImages)
                .build();
    }

}
