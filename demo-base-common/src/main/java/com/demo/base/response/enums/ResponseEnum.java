package com.demo.base.response.enums;

import com.demo.base.response.base.IResponseEnum;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public enum ResponseEnum implements IResponseEnum {

    /*** 正常响应 ***/
    NORMAL(100, "成功返回"),
    /*** 通用异常响应 ***/
    REQUEST_EXCEPTION(101, "请求异常"),
    REQUEST_IS_NULL(102, "请求为空"),
    PARAMETER_EXCEPTION(103, "参数异常"),
    PARAMETER_IS_NULL(104, "参数为空"),
    BUSINESS_EXCEPTION(105, "业务异常"),
    EXECUTION_EXCEPTION(106, "执行异常"),
    DATA_EXCEPTION(107, "数据异常"),
    RESPONSE_EXCEPTION(108, "响应异常"),
    RESPONSE_IS_NULL(109, "响应为空"),
    NETWORK_EXCEPTION(110, "网络异常"),
    SYSTEM_EXCEPTION(111, "系统异常"),
    OPERATION_EXCEPTION(112, "操作异常"),
    DAO_EXCEPTION(113, "数据访问异常"),
    /*** 定制异常响应 ***/
    PHONE_NUMBER_ENCRYPTION_EXCEPTION(201, "手机号码加密失败"),
    ;
    private int code;

    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
