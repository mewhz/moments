package com.mewhz.moments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCodeEnum {

    SUCCESS(0),

    FAIL(500);

    private final Integer code;

}
