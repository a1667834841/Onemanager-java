package com.zhu.onemanager.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
    *
     * @Description: 定义接口的总体信息
     * @param:  用户
     * @return springfox.documentation.service.ApiInfo
     * @author DnsLin
     * @date 2021/10/27 20:21
    */
    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("用户的接口文档")
                .description("本文档描述了用户接口定义")
                .version("1.0")
                .contact(new Contact("dnslin", "https://www.dnslin.com", "bolekmiss@gmail.com"))
                .build();
    }

    private ApiInfo adminApiInfo(){

        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了管理人员接口定义")
                .version("1.0")
                .contact(new Contact("dnslin", "https://www.dnslin.com", "bolekmiss@gmail.com"))
                .build();
    }

    @Bean
    public Docket webApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                // 用户组
                .groupName("webApi")
                // 组的信息
                .apiInfo(webApiInfo())
                .select()
                //只显示api路径下的页面
                // 用户接口的判断
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();

    }

    @Bean
    public Docket adminApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                // 管路⚪组
                .groupName("adminApi")
                // 组的信息
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();

    }
}
