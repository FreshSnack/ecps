package com.ahnu.ecps.aop;

import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层异常捕获处理
 * @Author: mxding
 * @Date: 2019-07-24 12:35
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 通用异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public AjaxReturn bizExHandler(Exception e) {
        return AjaxReturn.failure(e.getMessage());
    }
}
