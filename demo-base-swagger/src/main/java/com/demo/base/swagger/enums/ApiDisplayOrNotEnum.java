package com.demo.base.swagger.enums;

/**
 * @author Vince Yuan
 * @date 01/25/2021
 */
public enum ApiDisplayOrNotEnum {

    YES("yes", "APIs that satisfy Swagger configuration will be displayed on Swagger's documentation"),
    NO("no", "APIs that satisfy Swagger configuration will never be displayed on Swagger's documentation"),
    ;
    private String code;

    private String description;

    ApiDisplayOrNotEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public static ApiDisplayOrNotEnum find(String code) {
        for(ApiDisplayOrNotEnum apiDisplayOrNotEnum : values()) {
            String codeFromEnum = apiDisplayOrNotEnum.getCode();
            if (codeFromEnum == code || codeFromEnum.equalsIgnoreCase(code)) {
                return apiDisplayOrNotEnum;
            }
        }
        return null;
    }
}
