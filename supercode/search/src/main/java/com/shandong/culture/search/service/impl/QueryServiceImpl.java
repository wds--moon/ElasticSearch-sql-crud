package com.shandong.culture.search.service.impl;


import com.shandong.culture.search.common.constant.EsEnum;
import com.shandong.culture.search.service.QueryService;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
* @Description:    查询,具体根据业务查询
* @Author:         moon
* @CreateDate:     2019/4/30 0030 17:49
* @UpdateUser:     moon
* @UpdateDate:     2019/4/30 0030 17:49
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class QueryServiceImpl implements QueryService {

    @Resource
    TransportClient transportClient;

    @Override
    public List<Map<String, Object>> queryListFromES(EsEnum es, int storeId, String storeName, String startDate, String endDate) {
        List<Map<String, Object>> list = new ArrayList<>();
        return list;
    }

}
