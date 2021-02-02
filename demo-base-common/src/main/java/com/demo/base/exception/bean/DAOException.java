package com.demo.base.exception.bean;

import com.demo.base.exception.base.BaseException;
import com.demo.base.response.base.IResponseEnum;
import com.demo.base.response.enums.ResponseEnum;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class DAOException extends BaseException {

    public DAOException() {}

    public DAOException(IResponseEnum iResponseEnum) {
        super(iResponseEnum.getCode(), iResponseEnum.getMessage());
    }

    public DAOException(String message) {
        super(ResponseEnum.DAO_EXCEPTION.getCode(), message);
    }

    public DAOException(IResponseEnum iResponseEnum, String message) {
        super(iResponseEnum.getCode(), message);
    }

    public DAOException(int code, String message) {
        super(code, message);
    }

    public DAOException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public DAOException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
