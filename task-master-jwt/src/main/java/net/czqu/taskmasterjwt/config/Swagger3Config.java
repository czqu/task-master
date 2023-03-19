package net.czqu.taskmasterjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: task-master
 * @description:
 * @author: Paul Chen
 * @create: 2023-03-19 23:41
 **/
@EnableOpenApi
@Configuration
public class Swagger3Config {


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger 文档")
                .description("swagger接口文档")
                .version("1.0")
                .build();
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.czqu.taskmasterjwt"))
                .paths(PathSelectors.any())
                .build();
    }

}
