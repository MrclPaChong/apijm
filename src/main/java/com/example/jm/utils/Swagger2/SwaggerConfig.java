package com.example.jm.utils.Swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cl
 * @company XX公司
 * @create 2019-12-28 15:36
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.jm.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("对接上郡生活APP-Swagger接口文档")
                        .description("北台南塔中古城，六楼骑街天下名”，这是中国历史文化名城——榆林城的重要标志。其中“南塔”即为城南的凌霄塔，亦名文笔塔。")
                        .version("7.0")
                        .contact(new Contact("榆林凌霄塔社区平台对接上郡生活APP","http://148.70.156.132:8933/api","shanghai@meishutech.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build());
    }
}