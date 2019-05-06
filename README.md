# ElasticSearch-sql-crud
使用ElasticSearch-sql简单操作es,提供sql方式提供查询功能
采用springboot2+ElasticSearch.6.4.3
ElasticSearch-sql需要到官网下载指定版本,然后自己编译打包到自己的私服,或者在插件包手动引入
<dependency>
            <groupId>org.nlpcn</groupId>
            <artifactId>elasticsearch-sql</artifactId>
            <version>6.4.2.0</version>
        </dependency>
数据创建文件脚本
CREATE TABLE `t_article` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `context` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '正文',
  `topics` varchar(200) DEFAULT NULL COMMENT '主题',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update` datetime DEFAULT NULL COMMENT '最后编辑时间',
  `lable` varchar(500) DEFAULT NULL COMMENT '标签',
  `img_url` varchar(200) DEFAULT NULL COMMENT '图片路径集合',
  PRIMARY KEY (`id`),
  KEY `create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
