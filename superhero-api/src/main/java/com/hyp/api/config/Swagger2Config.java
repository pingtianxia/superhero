package com.hyp.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Vector;

/**
 * @路径: com.hyp.api.config.Swagger2Config
 * @描述: Swagger2配置文件
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-10-30 17:22
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    // TODO http://[ip]:[port]/[prjName]/swagger-ui.html
    // TODO http://[ip]:[port]/[prjName]/doc.html

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.hyp.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("电影预告api接口文档")
                .contact(new Contact("平天下技术服务", "www.baidu.com", "1285638034@qq.com"))
                .description("电影预告文档的描述信息")
                .version("1.0.0")
                .license("99999")
                .licenseUrl("www.qq.com")
                .termsOfServiceUrl("json.cn")
                .build();
    }
}
