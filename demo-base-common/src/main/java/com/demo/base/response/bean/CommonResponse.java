package com.demo.base.response.bean;

import com.demo.base.response.base.ToString;
import com.demo.base.response.enums.ResponseEnum;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
@ApiModel("通用响应结果")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> extends ToString {

    private int code;

    private String message;

    private List<T> data;

    private String systemTime;

    public CommonResponse(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.systemTime = String.valueOf(System.currentTimeMillis());
    }

    public CommonResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.systemTime = String.valueOf(System.currentTimeMillis());
    }

    public CommonResponse(int code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.systemTime = String.valueOf(System.currentTimeMillis());
    }
}
