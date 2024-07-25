package com.gy.mapapitest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwapperConfig {
    @Value("${process_env}")
    private String env;

    @Bean
    public Docket docket(Environment environment) {
        Boolean flag = false;
        if (!env.isEmpty() && env.equals("dev")) {
            flag = true;
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("MI")
                .apiInfo(apiInfo())
                .enable(flag)
                // 扫描配置
                .select()
                // 扫描指定包 .apis(RequestHandlerSelectors.withClassAnnotation(RequestMapping.class))
                .apis(RequestHandlerSelectors.basePackage("com.gy.mapapitest"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("mgy", "baidu.com","422992533@qq.com");
        return new ApiInfo("后端API",
                "Mgy的API",
                "1.0",
                "https://blog.csdn.net/qq_29897369/article/details/104585296",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
