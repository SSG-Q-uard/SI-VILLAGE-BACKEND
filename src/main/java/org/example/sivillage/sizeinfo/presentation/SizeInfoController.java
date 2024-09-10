package org.example.sivillage.sizeinfo.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.sivillage.auth.domain.CustomUserDetails;
import org.example.sivillage.global.common.response.BaseResponse;
import org.example.sivillage.sizeinfo.application.SizeInfoServiceImpl;
import org.example.sivillage.sizeinfo.dto.out.SizeInfoResponseDto;
import org.example.sivillage.sizeinfo.vo.in.SizeInfoRequestVo;
import org.example.sivillage.sizeinfo.vo.out.SizeInfoResponseVo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "회원 사이즈 정보 관리 API", description = "회원 사이즈 정보 관련 API endpoints")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/size-info")
public class SizeInfoController {

    private final SizeInfoServiceImpl sizeInfoService;

    @Operation(summary = "사이즈 정보 등록", description = "사이즈 정보를 등록합니다.")
    @PostMapping()
    public BaseResponse<Void> addSizeInfo(@Valid @RequestBody SizeInfoRequestVo sizeInfoRequestVo, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        sizeInfoService.addSizeInfo(SizeInfoRequestVo.toDto(sizeInfoRequestVo), customUserDetails.getMemberUuid()); // vo -> dto
        return new BaseResponse<>();
    }

    @Operation(summary = "사이즈 정보 조회", description = "사이즈 정보를 조회합니다.")
    @GetMapping()
    public BaseResponse<SizeInfoResponseVo> getSizeInfo(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        SizeInfoResponseDto sizeInfoResponseDto = sizeInfoService.getSizeInfo(customUserDetails.getMemberUuid());
        return new BaseResponse<>(sizeInfoResponseDto.toResponseVo());
    }

    @Operation(summary = "사이즈 정보 수정", description = "사이즈 정보를 수정합니다.")
    @PutMapping()
    public BaseResponse<Void> changeSizeInfo(@Valid @RequestBody SizeInfoRequestVo sizeInfoRequestVo, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        sizeInfoService.changeSizeInfo(SizeInfoRequestVo.toDto(sizeInfoRequestVo),customUserDetails.getMemberUuid());
        return new BaseResponse<>();

    }

    @Operation(summary = "사이즈 정보 삭제", description = "사이즈 정보를 삭제합니다.")
    @DeleteMapping()
    public BaseResponse<Void> deleteSizeInfo(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        sizeInfoService.removeSizeInfo(customUserDetails.getMemberUuid());
        return new BaseResponse<>();
    }


}
