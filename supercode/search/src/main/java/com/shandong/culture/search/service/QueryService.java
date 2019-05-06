package com.shandong.culture.search.service;


import com.shandong.culture.search.common.constant.EsEnum;

import java.util.List;
import java.util.Map;

/**
* @Description:    根据业务编写查询
* @Author:         moon
* @CreateDate:     2019/4/30 0030 17:50
* @UpdateUser:     moon
* @UpdateDate:     2019/4/30 0030 17:50
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface QueryService {

    List<Map<String, Object>> queryListFromES(EsEnum es, int storeId, String storeName, String startDate, String endDate);

}
