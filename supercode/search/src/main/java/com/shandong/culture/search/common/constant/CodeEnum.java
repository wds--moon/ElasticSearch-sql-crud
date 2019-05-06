package com.shandong.culture.search.common.constant;

/**
* @Description:    枚举常用类
* @Author:         moon
* @CreateDate:     2019/5/5 0005 14:04
* @UpdateUser:     moon
* @UpdateDate:     2019/5/5 0005 14:04
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public enum CodeEnum {
    SUCCESS(0, "success"),
    FAILURE(1, "failure");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CodeEnum valueOf(int code) {
        CodeEnum[] var1 = values();
        int var2 = var1.length;
        for(int var3 = 0; var3 < var2; ++var3) {
            CodeEnum codeEnum = var1[var3];
            if(codeEnum.code == code) {
                return codeEnum;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }
}
