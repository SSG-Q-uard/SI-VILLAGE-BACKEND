package org.example.sivillage.global.common.response.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.sivillage.global.common.response.vo.IdListResponseVo;

@NoArgsConstructor
@Getter
public class IdListResponseDto<T> {

    private T id;

    @Builder
    public IdListResponseDto(T id) {
        this.id = id;
    }

    public static <T> IdListResponseDto<T> from(T id) {
        return IdListResponseDto.<T>builder()
                .id(id)
                .build();
    }

    public IdListResponseVo<T> toVo() {
        return IdListResponseVo.<T>builder()
                .id(this.id)
                .build();
    }
}
