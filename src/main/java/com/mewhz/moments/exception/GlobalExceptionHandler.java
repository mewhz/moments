package com.mewhz.moments.exception;

import com.mewhz.moments.model.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public ResultVO<String> bizExceptionHandler(BizException e) {
        return ResultVO.fail(e.getMessage());
    }

}
