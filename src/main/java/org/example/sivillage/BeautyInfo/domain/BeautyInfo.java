package org.example.sivillage.BeautyInfo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.sivillage.BeautyInfo.domain.beautyenum.ScalpTone;
import org.example.sivillage.BeautyInfo.domain.beautyenum.SkinTone;
import org.example.sivillage.BeautyInfo.domain.beautyenum.SkinType;
import org.example.sivillage.global.common.BaseEntity;
import org.example.sivillage.BeautyInfo.dto.in.BeautyInfoRequestDto;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class BeautyInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beauty_info_id")
    private Long beautyInfoId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkinType skinType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkinTone skinTone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScalpTone scalpTone;

    @Column(nullable = false)
    private String beautyKeyword;

    @Column(nullable = false)
    private String memberUuid;

    @Builder
    public BeautyInfo(SkinType skinType, SkinTone skinTone, ScalpTone scalpTone, String beautyKeyword, String memberUuid) {
        this.skinType = skinType;
        this.skinTone = skinTone;
        this.scalpTone = scalpTone;
        this.beautyKeyword = beautyKeyword;
        this.memberUuid = memberUuid;
    }

    public static BeautyInfo toEntity (BeautyInfoRequestDto dto, String memberUuid) {
        return BeautyInfo.builder()
                .skinType(dto.getSkinType())
                .skinTone(dto.getSkinTone())
                .scalpTone(dto.getScalpTone())
                .beautyKeyword(dto.getBeautyKeyword())
                .memberUuid(memberUuid)
                .build();
    }

    public void change(BeautyInfoRequestDto dto) {
        this.skinType = dto.getSkinType();
        this.skinTone = dto.getSkinTone();
        this.scalpTone = dto.getScalpTone();
        this.beautyKeyword = dto.getBeautyKeyword();
    }


}




