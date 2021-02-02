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
    REQUEST_ERROR(101, "请求异常"),
    REQUEST_IS_NULL(102, "请求为空"),
    PARAMETER_ERROR(103, "参数异常"),
    PARAMETER_IS_NULL(104, "参数为空"),
    BUSINESS_ERROR(105, "业务异常"),
    EXECUTION_ERROR(106, "执行异常"),
    DATA_ERROR(107, "数据异常"),
    RESPONSE_ERROR(108, "响应异常"),
    RESPONSE_IS_NULL(109, "响应为空"),
    NETWORK_ERROR(110, "网络异常"),
    SYSTEM_ERROR(111, "系统异常"),
    OPERATION_ERROR(112, "操作异常"),
    /*** 定制异常响应 ***/
    PHONE_NUMBER_ENCRYPTION_ERROR(201, "手机号码加密失败"),
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
