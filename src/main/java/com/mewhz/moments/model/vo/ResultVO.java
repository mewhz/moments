package com.mewhz.moments.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.mewhz.moments.enums.StatusCodeEnum.FAIL;
import static com.mewhz.moments.enums.StatusCodeEnum.SUCCESS;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {

//    private Boolean flag;

    private Integer code;

    private String message;

    private T data;

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVO(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> ResultVO<T> success() {
        return new ResultVO<>(SUCCESS.getCode(), null);
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(SUCCESS.getCode(),  data);
    }

    public static <T> ResultVO<T> fail(String message) {
        return new ResultVO<>(FAIL.getCode(), message);
    }

}
