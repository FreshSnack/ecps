package com.ahnu.ecps.exception;

/**
 * 业务异常
 * @author dingmx
 * @date 2019/7/28 09:38
 */
public class BusinessException extends RuntimeException {


    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
