package com.demo.base.common.response.base;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public interface IResponseEnum {

    /**
     *  Get the return code
     *
     * @return
     */
    int getCode();

    /**
     *  Get the return message
     *
     * @return
     */
    String getMessage();
}
