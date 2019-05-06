package com.shandong.culture.search.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/*
使用示例说明：
{
   		"meta": {
       	        	 "msg": "success",                     //返回的是错误提示信息
       		         "error": 0                            //0代表成功  1，代表失败，其他错误码自己定义
                },
        "result": {
                     "data":{} or []                       //多行记录返回数组
                     "page":{                              //page 是可选项，data为数组时才会有page，也可以无page信息（不分页）。
                            "currentPage"":1 ,             //当前页,目前系统有从0或1开始。统一1开始
                            "pageSize":10,                 //分页的数量
                            "totalPage":1,                 //总页数
                            "totalCount":10                //总行数
                        }
                   }
}
*/

/**
* @Description:    统一返回值操作类
* @Author:         moon
* @CreateDate:     2019/5/5 0005 13:50
* @UpdateUser:     moon
* @UpdateDate:     2019/5/5 0005 13:50
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ResponseVO implements Serializable {

    public static final Meta SUCCESS = new Meta(0, "success");
    public static final Meta FAILURE = new Meta(1, "failure");
    /**
     *  error=0：成功,error=1:失败
      */
    private Meta meta;
    /**
     * 数据
     */

    private Result result;


    /**
     * 成功返回值对象
     *
     * @return ResponseData
     */
    public static ResponseVO success() {
        return new ResponseVO(ResponseVO.SUCCESS, null);
    }

    /**
     * 成功返回值对象
     *
     * @param data 数据
     * @return ResponseData
     */
    public static <T> ResponseVO success(T data) {
        return new ResponseVO(ResponseVO.SUCCESS, new Result(data, null));
    }

    /**
     * 分页成功返回值对象
     *
     * @param data        数据
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @param totalCount  总行数
     * @return ResponseData
     */
    public static <T> ResponseVO success(T data, Integer currentPage, Integer pageSize, long totalCount) {
        return new ResponseVO(ResponseVO.SUCCESS, data, currentPage, pageSize, Integer.parseInt(String.valueOf(totalCount)));
    }


    /**
     * 失败返回值对象
     *
     * @return ResponseData
     */
    public static ResponseVO failure() {
        return new ResponseVO(ResponseVO.FAILURE, null);
    }


    /**
     * 失败码/失败信息回值对象
     *
     * @param error
     * @param msg
     * @return ResponseData
     */
    public static ResponseVO failure(int error, String msg) {
        return new ResponseVO(new Meta(error, msg), null);
    }


    private <T> ResponseVO(Meta meta, T data, Integer currentPage, Integer pageSize, Integer totalCount) {
        this.meta = meta;
        if (data != null && currentPage != null && pageSize != null && totalCount != null) {
            this.result = new Result(data, new Page(currentPage, pageSize, totalCount));
        }
    }


    private ResponseVO(Meta meta, Result result) {
        this.meta = meta;
        this.result = result;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(int error, String msg) {
        this.meta = new Meta(error, msg);
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result<T> implements Serializable {
        private Page page;
        private T data;

        private Result() {
        }

        private Result(T data, Page page) {
            this.data = data;
            this.page = page;
        }

        public Page getPage() {
            return page;
        }


        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("page", page)
                    .append("data", data)
                    .toString();
        }
    }

    public static class Meta implements Serializable {
        /**
         * 错误码
         */
        private int error;
        /**
         * 提示信息
         */
        private String msg;

        private Meta() {
        }

        private Meta(int error, String msg) {
            this.error = error;
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }


        public int getError() {
            return error;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Meta meta = (Meta) o;

            return new EqualsBuilder()
                    .append(error, meta.error)
                    .append(msg, meta.msg)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(error)
                    .append(msg)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("error", error)
                    .append("msg", msg)
                    .toString();
        }
    }

    public static class Page implements Serializable {
        /**
         * 当前页：统一从1开始
         */
        private Integer currentPage;
        /**
         * 每页行数
         */
        private Integer pageSize = 10;
        /**
         * 总行数
         */
        private Integer totalCount;
        /**
         * 总页数
         */
        private Integer totalPage = 0;
        private Page() {
        }

        private Page(Integer currentPage, Integer pageSize, Integer totalCount) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
            this.totalCount = totalCount;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }


        public Integer getPageSize() {
            return pageSize;
        }


        public Integer getTotalCount() {
            return totalCount;
        }

        /**
         * 总页数
         *
         * @return
         */
        public Integer getTotalPage() {
            if (this.pageSize != null && this.pageSize > 0) {
                if (totalCount % pageSize == 0) {
                    totalPage = totalCount / pageSize;
                } else {
                    totalPage = totalCount / pageSize + 1;
                }
            }
            return totalPage;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("currentPage", currentPage)
                    .append("pageSize", pageSize)
                    .append("totalCount", totalCount)
                    .toString();
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("meta", meta)
                .append("result", result)
                .toString();
    }

}