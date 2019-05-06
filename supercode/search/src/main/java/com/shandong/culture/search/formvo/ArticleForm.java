package com.shandong.culture.search.formvo;

import com.shandong.culture.search.entity.Article;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * @Description: 参数接受接口
 * @Author: moon
 * @CreateDate: 2019/5/5 0005 14:46
 * @UpdateUser: moon
 * @UpdateDate: 2019/5/5 0005 14:46
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
public class ArticleForm extends BaseForm {
    /**
     * 标题
     */
    private String title;

    /**
     * 主题
     */
    private String topics;

    /**
     * 标签
     */
    private String lable;

    /**
     * 图片路径集合
     */
    private String imgUrl;
    /**
     * 正文
     */
    private String context;


}
