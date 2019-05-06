package com.shandong.culture.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.shandong.culture.search.common.constant.EsEnum;
import com.shandong.culture.search.entity.Article;
import com.shandong.culture.search.formvo.ArticleForm;
import com.shandong.culture.search.mapper.ArticleMapper;
import com.shandong.culture.search.model.ResponseVO;
import com.shandong.culture.search.service.ArticleService;
import com.shandong.culture.search.service.ElasticSearchService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.nlpcn.es4sql.SearchDao;
import org.nlpcn.es4sql.exception.SqlParseException;
import org.nlpcn.es4sql.query.SqlElasticSearchRequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLFeatureNotSupportedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author moon
 * @create 2019-05-05 14:51
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ElasticSearchService elasticSearchService;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    TransportClient transportClient;

    @Override
    public void save(ArticleForm article) {
        Article info = getArticle(article);
        articleMapper.insert(info);
        elasticSearchService.insertById(EsEnum.INDEX.getValue(), EsEnum.TYPE.getValue(), String.valueOf(info.getId()), JSON.toJSONString(info));

    }

    /**
     * 数据转换
     *
     * @param article
     * @return
     */
    private Article getArticle(ArticleForm article) {
        Article info = new Article();
        info.setContext(article.getContext());
        info.setCreateTime(LocalDateTime.now());
        info.setLastUpdate(LocalDateTime.now());
        info.setTitle(article.getTitle());
        info.setLable(article.getLable());
        info.setImgUrl(article.getImgUrl());
        return info;
    }

    @Override
    public void update(ArticleForm article) {

    }

    @Override
    public void delete(String id) {
        elasticSearchService.deleteById(EsEnum.INDEX.getValue(), EsEnum.TYPE.getValue(), id);
    }

    @Override
    public ResponseVO findArticle(ArticleForm article) {
        StringBuilder sql = new StringBuilder("select * from").append(EsEnum.INDEX.getValue());
        sql.append(" where  1=1 ");
        if (StringUtils.isNotEmpty(article.getTitle())) {
            sql.append(" and title ='").append(article.getTitle()).append("'");
        }
        sql.append(" limit ").append(article.getPageNum()).append(" , ").append(article.getPageSize());
        SearchHits response = null;
        try {
            response = query(sql.toString());
        } catch (Exception e) {
            return null;
        }
        return ResponseVO.success(setListMap(response), article.getPageNum(), article.getPageSize(), response.totalHits);
    }

    @Override
    public ResponseVO matchQueryArticle(ArticleForm article) {

        StringBuilder sql = new StringBuilder("select * from ").append(EsEnum.INDEX.getValue());
        sql.append(" where  1=1 ");
        if (StringUtils.isNotEmpty(article.getTitle())) {
            sql.append(" and title = matchQuery('").append(article.getTitle()).append("')");
        }
        if (StringUtils.isNotEmpty(article.getContext())) {
            sql.append(" and  context = matchQuery('").append(article.getContext()).append("')");
        }
        sql.append(" limit ").append(article.getPageNum()).append(" , ").append(article.getPageSize());
        SearchHits response = null;
        try {
            response = query(sql.toString());
        } catch (Exception e) {
            return null;
        }
        return ResponseVO.success(setListMap(response), article.getPageNum(), article.getPageSize(), response.totalHits);
    }

    private List<Map<String, Object>> setListMap(SearchHits response) {
        List<Map<String, Object>> data = new ArrayList<>();
        for (SearchHit hit : response.getHits()) {
            data.add(hit.getSourceAsMap());
        }
        return data;
    }

    private SearchHits query(String query) throws SqlParseException, SQLFeatureNotSupportedException {
        SearchDao searchDao = new SearchDao(transportClient);
        SqlElasticSearchRequestBuilder select = (SqlElasticSearchRequestBuilder) searchDao.explain(query).explain();
        return ((SearchResponse) select.get()).getHits();
    }

}
