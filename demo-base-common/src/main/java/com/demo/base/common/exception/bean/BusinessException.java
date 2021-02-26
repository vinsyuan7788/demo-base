package com.demo.base.common.exception.bean;

import com.demo.base.common.exception.base.BaseException;
import com.demo.base.common.response.base.IResponseEnum;
import com.demo.base.common.response.enums.ResponseEnum;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class BusinessException extends BaseException {

    /***   Below are the constructors that keep the structure of parent class   ***/
    public BusinessException() {}

    public BusinessException(String message) {
        super(ResponseEnum.BUSINESS_EXCEPTION.getCode(), message);
    }

    /***   Below are the constructors that contains custom fields   ***/
    public BusinessException(IResponseEnum iResponseEnum) {
        super(iResponseEnum.getCode(), iResponseEnum.getMessage());
    }

    public BusinessException(IResponseEnum iResponseEnum, Exception exception) {
        super(iResponseEnum.getCode(), iResponseEnum.getMessage(), exception);
    }

    public BusinessException(IResponseEnum iResponseEnum, String message) {
        super(iResponseEnum.getCode(), message);
    }

    public BusinessException(IResponseEnum iResponseEnum, String message, Exception exception) {
        super(iResponseEnum.getCode(), message, exception);
    }

    public BusinessException(int code, String message) {
        super(code, message);
    }

    public BusinessException(int code, String message, Exception exception) {
        super(code, message, exception);
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public BusinessException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
