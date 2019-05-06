package com.shandong.culture.manager.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;

@Table(name = "`t_article`")
@Data
public class Article {
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 主题
     */
    @Column(name = "`topics`")
    private String topics;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private LocalDateTime createTime;

    /**
     * 最后编辑时间
     */
    @Column(name = "`last_update`")
    private LocalDateTime lastUpdate;

    /**
     * 标签
     */
    @Column(name = "`lable`")
    private String lable;

    /**
     * 图片路径集合
     */
    @Column(name = "`img_url`")
    private String imgUrl;

    /**
     * 正文
     */
    @Column(name = "`context`")
    private String context;
}