package org.example.sivillage.global.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum BaseResponseStatus {

    // 200: 요청 성공
    SUCCESS(HttpStatus.OK, true, "요청에 성공하였습니다."),

    // 400: Bad Request
    AUTH_CODE_INVALID(HttpStatus.BAD_REQUEST, false, "인증 코드가 틀렸습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "잘못된 요청입니다."),
    NOT_FOUND_BEAUTY_INFO(HttpStatus.NOT_FOUND, false,"뷰티 정보가 등록되어 있지 않습니다. 뷰티 정보를 먼저 생성해주세요."),
    NOT_FOUND_SIZE_INFO(HttpStatus.NOT_FOUND,false,"사이즈 정보가 등록되어 있지 않습니다. 사이즈 정보를 먼저 생성해주세요"),
    NOT_FOUND_SHIPPING_ADDRESS(HttpStatus.NOT_FOUND,false,"배송지가 등록되어 있지 않습니다. 배송지를 먼저 등록해주세요."),
    FILE_PARSE_FAILED(HttpStatus.BAD_REQUEST, false, "JSON 파싱에 실패했습니다."),
    INVALID_FILE_FORMAT(HttpStatus.BAD_REQUEST, false, "파일 포맷이 잘못됐습니다."),
    /*
     * 404 NOT_FOUND: 리소스를 찾을 수 없음
     */
    NOT_FOUND_CART(HttpStatus.NOT_FOUND, false, "장바구니 상품을 찾을 수 없습니다."),
    EVENT_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, false, "해당하는 이벤트 이미지를 찾을 수 없습니다."),
    EVENT_NOT_FOUND(HttpStatus.NOT_FOUND, false, "해당하는 이벤트를 찾을 수 없습니다."),
    QUESTION_NOT_FOUND(HttpStatus.NOT_FOUND,false,"해당하는 상품문의를 찾을 수 없습니다."),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND,false,"해당하는 리뷰를 찾을 수 없습니다."),
    REVIEW_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND,false,"해당하는 리뷰이미지를 찾을 수 없습니다."),
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, false, "게시글 정보를 찾을 수 없습니다."),
    BRAND_NOT_FOUND(HttpStatus.NOT_FOUND, false, "해당하는 브랜드 명을 찾을 수 없습니다."),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, false, "해당하는 상품 정보를 찾을 수 없습니다."),
    NOT_FOUND_PRODUCT_OPTION(HttpStatus.NOT_FOUND, false, "제품의 옵션 정보를 찾을 수 없습니다."),
    BRAND_LIKE_NOT_FOUND(HttpStatus.NOT_FOUND,false, "해당하는 브랜드 좋아요 정보를 찾을 수 없습니다."),
    TOP_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,false, "해당하는 top 카테고리 정보를 찾을 수 없습니다."),
    MIDDLE_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,false, "해당하는 middle 카테고리 정보를 찾을 수 없습니다."),
    BOTTOM_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,false, "해당하는 bottom 카테고리 정보를 찾을 수 없습니다."),
    SUB_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,false, "해당하는 sub 카테고리 정보를 찾을 수 없습니다."),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,false, "카테고리 정보를 찾을 수 없습니다."),
    PRODUCT_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, false, "해당하는 상품 썸네일을 찾을 수 없습니다."),
    NOT_FOUND_BRAND_LIKE(HttpStatus.NOT_FOUND, false, "해당하는 브랜드 좋아요 정보를 찾을 수 없습니다."),
    NOT_FOUND_COLOR(HttpStatus.NOT_FOUND, false, "해당하는 색상 정보를 찾을 수 없습니다."),
    NOT_FOUND_SIZE(HttpStatus.NOT_FOUND, false, "해당하는 사이즈 정보를 찾을 수 없습니다."),
    NOT_FOUND_PRODUCT(HttpStatus.NOT_FOUND, false, "해당하는 상품 정보를 찾을 수 없습니다."),
    NOT_FOUND_PURCHASE(HttpStatus.NOT_FOUND, false, "해당하는 구매 정보를 찾을 수 없습니다."),

    /*
     * 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출
     */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, false, "허용되지 않은 메서드입니다."),

    /*
     * 500 INTERNAL_SERVER_ERROR: 내부 서버 오류
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "내부 서버 오류입니다."),
    VALIDATION_FAILURE(HttpStatus.BAD_REQUEST, false, "유효성 검사에 실패했습니다."),
    INVALID_REQUEST_BODY(HttpStatus.BAD_REQUEST, false, "요청 본문이 유효하지 않습니다."),
    PAYMENT_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, false, "결제에 실패했습니다."),

    // 인증 관련
    FAILED_TO_LOGIN(HttpStatus.INTERNAL_SERVER_ERROR, false, "로그인에 실패했습니다."),
    FAILED_TO_REGISTRATION(HttpStatus.INTERNAL_SERVER_ERROR, false, "회원가입에 실패했습니다."),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, false,  "리프레시 토큰이 유효하지 않습니다."),
    NOT_FOUND_REFRESH_TOKEN(HttpStatus.NOT_FOUND, false,  "리프레시 토큰을 찾지 못했습니다."),
    NOT_MATCHED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, false,  "DB의 리프레시 토큰값과 일치하지 않습니다."),
    EXPIRED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, false,  "리프레시 토큰이 만료되었습니다."),
    EXPIRED_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, false, "엑세스 토큰이 만료되었습니다."),
    ACCOUNT_NOT_MATCHED(HttpStatus.BAD_REQUEST, false,  "로그인 된 회원정보와 다른 유저의 요청입니다."),
    LOGIN_FAILURE(HttpStatus.UNAUTHORIZED, false, "아이디나 비밀번호가 잘못되었습니다."),
    STUDENT_ID_DUPLICATION(HttpStatus.CONFLICT, false,  "이미 사용 중인 학번입니다."),
    ALREADY_FRIEND(HttpStatus.CONFLICT, false,  "이미 친구로 추가된 회원입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, false,  "해당하는 회원을 찾을 수 없습니다."),
    WRONG_JWT_TOKEN(HttpStatus.UNAUTHORIZED, false,  "다시 로그인 해주세요."),
    NO_SIGN_IN(HttpStatus.UNAUTHORIZED, false ,  "인증 오류"),

    // 권한 관련
    NO_AUTHORITY_FOUND(HttpStatus.NOT_FOUND, false,  "회원의 권한 정보를 찾을 수 없습니다"),
    UNAUTHORIZED_MEMBER(HttpStatus.UNAUTHORIZED, false,  "접근 권한이 없습니다."),
    UNAUTHORIZED_TASK(HttpStatus.UNAUTHORIZED, false,  "허용되지 않은 권한입니다."),


    // 중복 요청 관련
    DUPLICATE_CART(HttpStatus.CONFLICT,false,"이미 쇼핑백에 담겨 있는 상품입니다. 쇼핑백 수량을 추가 하시겠습니까?"),
    DUPLICATE_PRODUCT(HttpStatus.CONFLICT, false,  "이미 존재하는 상품명입니다."),
    DuPLICATE_ADDRESS(HttpStatus.CONFLICT, false, "이미 배송지가 등록되었습니다."),
    DUPLICATE_BRAND_NAME(HttpStatus.CONFLICT, false,  "이미 존재하는 브랜드명입니다."),
    DUPLICATE_BEAUTY_INFO(HttpStatus.CONFLICT,false,"이미 존재하는 뷰티 정보입니다."),
    DUPLICATE_SIZE_INFO(HttpStatus.CONFLICT,false,"이미 존재하는 사이즈 정보입니다."),
    DUPLICATE_CATEGORY_NAME(HttpStatus.CONFLICT, false, "이미 존재하는 카테고리 이름입니다."), ;

    private final HttpStatusCode httpStatusCode;
    private final boolean isSuccess;
    private final String message;
}
