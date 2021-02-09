package com.demo.base.response.bean;

import com.demo.base.response.base.IResponseEnum;
import com.demo.base.response.base.ToString;
import com.demo.base.response.enums.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Vince Yuan
 * @date 02/02/2021
 */
@ApiModel("通用响应结果")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> extends ToString {

    @ApiModelProperty("响应码")
    private int code;

    @ApiModelProperty("响应信息")
    private String message;

    @ApiModelProperty("响应数据")
    private List<T> data;

    @ApiModelProperty("系统时间")
    private String systemTime;

    public CommonResponse(IResponseEnum iResponseEnum) {
        this.code = iResponseEnum.getCode();
        this.message = iResponseEnum.getMessage();
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
