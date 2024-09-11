package org.example.sivillage.auth.dto.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.sivillage.auth.vo.out.JwtTokenResponseVo;

@Getter
@NoArgsConstructor
public class JwtTokenResponseDto {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private String memberUuid;

    @Builder
    public JwtTokenResponseDto(String grantType, String accessToken, String refreshToken, String memberUuid) {
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.memberUuid = memberUuid;
    }

    public JwtTokenResponseVo toVo() {
        return JwtTokenResponseVo.builder()
                .grantType(getGrantType())
                .accessToken(getAccessToken())
                .refreshToken(getRefreshToken())
                .memberUuid(getMemberUuid())
                .build();
    }
}
