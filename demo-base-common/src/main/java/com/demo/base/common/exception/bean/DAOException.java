package com.demo.base.common.exception.bean;

import com.demo.base.common.exception.base.BaseException;
import com.demo.base.common.response.base.IResponseEnum;
import com.demo.base.common.response.enums.ResponseEnum;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public class DAOException extends BaseException {

    /***   Below are the constructors that keep the structure of parent class   ***/
    public DAOException() {}

    public DAOException(String message) {
        super(ResponseEnum.DAO_EXCEPTION.getCode(), message);
    }

    /***   Below are the constructors that contains custom fields   ***/
    public DAOException(IResponseEnum iResponseEnum) {
        super(iResponseEnum.getCode(), iResponseEnum.getMessage());
    }

    public DAOException(IResponseEnum iResponseEnum, Exception exception) {
        super(iResponseEnum.getCode(), iResponseEnum.getMessage(), exception);
    }

    public DAOException(IResponseEnum iResponseEnum, String message) {
        super(iResponseEnum.getCode(), message);
    }

    public DAOException(IResponseEnum iResponseEnum, String message, Exception exception) {
        super(iResponseEnum.getCode(), message, exception);
    }

    public DAOException(int code, String message) {
        super(code, message);
    }

    public DAOException(int code, String message, Exception exception) {
        super(code, message, exception);
    }

    public DAOException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public DAOException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
