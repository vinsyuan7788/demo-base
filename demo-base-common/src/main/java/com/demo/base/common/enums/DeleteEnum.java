package com.demo.base.common.enums;

/**
 * @author Vince Yuan
 * @date 02/09/2021
 */
public enum DeleteEnum {

    NORMAL("normal", "正常"),
    DELETE("delete", "删除")
    ;
    private String code;

    private String description;

    DeleteEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static DeleteEnum findByCode(String code) {
        for (DeleteEnum deleteEnum : values()) {
            String codeFromEnum = deleteEnum.getCode();
            if (codeFromEnum == code || codeFromEnum.equals(code)) {
                return deleteEnum;
            }
        }
        return null;
    }
}
