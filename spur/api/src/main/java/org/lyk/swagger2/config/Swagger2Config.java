package org.lyk.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by yuankliu on 07/04/2018.
 */
@Configuration
public class Swagger2Config
{
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.lyk"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title("spur项目API文档")
                .description("人多的时候最沉默,笑容也寂寞。在万丈红尘中，找个坦克来爱我。")
                .termsOfServiceUrl("https://www.cnblogs.com/kuillldan/")
                .version("1.0")
                .build();
    }
}
