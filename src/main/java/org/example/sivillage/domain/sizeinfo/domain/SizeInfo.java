package org.example.sivillage.domain.sizeinfo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.sivillage.domain.member.domain.Member;
import org.example.sivillage.domain.product.domain.Size;
import org.example.sivillage.global.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class SizeInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_info_id")
    private Long id;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size topSize;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size pantsSize;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

}