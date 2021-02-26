package com.demo.base.common.exception.base;

import lombok.Data;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
@Data
public class BaseException extends RuntimeException {

    /**
     *  To store exception code <br/>
     *  -- Which can be customized
     */
    private int code;

    /**
     *  To store the exception <br/>
     *  -- Which can be retrieved for further processing (e.g. {@link com.demo.base.exception.handler.GlobalExceptionHandler})
     */
    private Exception exception;

    /***   Below are the constructors that keep the structure of parent class   ***/
    public BaseException() { }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /***   Below are the constructors that contains custom fields   ***/
    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(int code, String message, Exception exception) {
        super(message, exception.getCause());
        this.code = code;
        this.exception = exception;
    }

    public BaseException(int code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
