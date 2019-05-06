package com.shandong.culture.search.service;


/**
* @Description:    批量操作es
* @Author:         moon
* @CreateDate:     2019/4/30 0030 17:48
* @UpdateUser:     moon
* @UpdateDate:     2019/4/30 0030 17:48
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface BulkProcessorService {

    void insertById(String index, String type, String id, String jsonStr);

    void updateById(String index, String type, String id, String jsonStr);

    void deleteById(String index, String type, String id);
}
