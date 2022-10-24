package com.xcx.gulimall.product.exception;

import com.xcx.common.exception.BizCodeEnume;
import com.xcx.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.xcx.gulimall.product.controller")

public class GulimallExcepitonControllerAdvice {

    @ExceptionHandler
    public R handleValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError -> {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());

        }));
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data",map);
    }
}
