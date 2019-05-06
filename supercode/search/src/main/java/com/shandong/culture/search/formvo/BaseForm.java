package com.shandong.culture.search.formvo;

import lombok.Data;

/**
 * @author moon
 * @create 2019-05-06 13:25
 **/
@Data
public class BaseForm {
    /**
     * 页数
     */
    private Integer pageNum=0;

    /**
     * 取多少条
     */
    private Integer pageSize=10;
    /**
     * 排序字段以逗号隔开
     */
    private String orderBy;
    /**
     * 分组字段以逗号隔开
     */
    private String groupBy;
}
