package com.shandong.culture.search.service;

import com.shandong.culture.search.common.constant.EsEnum;
import com.shandong.culture.search.entity.Article;
import com.shandong.culture.search.formvo.ArticleForm;
import com.shandong.culture.search.model.ResponseVO;
import org.elasticsearch.search.SearchHit;
import org.nlpcn.es4sql.exception.SqlParseException;

import java.sql.SQLFeatureNotSupportedException;
import java.util.Map;

/**
 * @Description: 业务处理类
 * @Author: moon
 * @CreateDate: 2019/5/5 0005 14:49
 * @UpdateUser: moon
 * @UpdateDate: 2019/5/5 0005 14:49
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface ArticleService {

    void save(ArticleForm article);

    void update(ArticleForm article);

    void delete(String articleId);

    ResponseVO findArticle(ArticleForm article);

    ResponseVO matchQueryArticle(ArticleForm article);

}
