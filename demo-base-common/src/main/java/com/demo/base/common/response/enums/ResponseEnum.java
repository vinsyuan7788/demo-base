package com.demo.base.common.response.enums;

import com.demo.base.common.response.base.IResponseEnum;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
public enum ResponseEnum implements IResponseEnum {

    /*** 正常响应 ***/
    SUCCESS(100, "执行成功"),
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
    PHONE_NUMBER_ENCRYPTION_EXCEPTION(201, "手机号码加密异常"),
    INSERT_FAIL(301, "插入数据异常"),
    UPDATE_FAIL(302, "更新数据异常"),
    DELETE_FAIL(303, "删除数据异常"),
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
