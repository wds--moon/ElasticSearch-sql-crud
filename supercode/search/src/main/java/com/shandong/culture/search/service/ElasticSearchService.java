package com.shandong.culture.search.service;



public interface ElasticSearchService {

    void insertById(String index, String type, String id, String jsonStr);

    void updateById(String index, String type, String id, String jsonStr);

    void deleteById(String index, String type, String id);

}
