package com.shandong.culture.search.common.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author moon
 * @create 2018-08-03 16:30
 **/
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T>{

}
