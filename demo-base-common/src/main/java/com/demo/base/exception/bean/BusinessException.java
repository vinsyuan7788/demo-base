package com.demo.base.exception.bean;

import com.demo.base.exception.base.BaseException;
import com.demo.base.response.base.IResponseEnum;
import com.demo.base.response.enums.ResponseEnum;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class BusinessException extends BaseException {

    public BusinessException() {}

    public BusinessException(IResponseEnum iResponseEnum) {
        super(iResponseEnum.getCode(), iResponseEnum.getMessage());
    }

    public BusinessException(String message) {
        super(ResponseEnum.BUSINESS_EXCEPTION.getCode(), message);
    }

    public BusinessException(IResponseEnum iResponseEnum, String message) {
        super(iResponseEnum.getCode(), message);
    }

    public BusinessException(int code, String message) {
        super(code, message);
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public BusinessException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
