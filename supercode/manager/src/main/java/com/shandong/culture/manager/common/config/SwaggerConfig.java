package com.shandong.culture.manager.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @Description:    Swagger配置操作类
* @Author:         moon
* @CreateDate:     2019/5/5 0005 14:10
* @UpdateUser:     moon
* @UpdateDate:     2019/5/5 0005 14:10
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shandong"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger2APIs")
                .description("接口文档说明")
                .termsOfServiceUrl("服务网址条款")
                .contact("接口")
                .version("1.0")
                .build();
    }
}


