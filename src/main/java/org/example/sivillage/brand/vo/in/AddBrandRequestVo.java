package org.example.sivillage.brand.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddBrandRequestVo {

    private String brandEngName;

    private String brandKorName;

    private String brandIndexLetter;

    private String brandIndexLetterKor;

    @Builder
    public AddBrandRequestVo(String brandEngName, String brandKorName, String brandIndexLetter, String brandIndexLetterKor) {
        this.brandEngName = brandEngName;
        this.brandKorName = brandKorName;
        this.brandIndexLetter = brandIndexLetter;
        this.brandIndexLetterKor = brandIndexLetterKor;
    }
}
