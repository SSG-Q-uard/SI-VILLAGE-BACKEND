package org.example.sivillage.member.domain.memberenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SkinType {

    DRY("건성"),
    NEUTRAL("중성"),
    OILY("지성"),
    COMBINATION("복합성");

    private final String description;
}