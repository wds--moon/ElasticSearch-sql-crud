package com.shandong.culture.search.common.constant;

/**
 * @Description: 枚举类型
 * @Author: moon
 * @CreateDate: 2019/5/5 0005 14:18
 * @UpdateUser: moon
 * @UpdateDate: 2019/5/5 0005 14:18
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public enum EsEnum {
    INDEX("shandong"),
    TYPE("culture");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    EsEnum(String value) {
        this.value = value;
    }
}
