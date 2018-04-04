package com.spring.studybyfirst.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    public Docket swaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis( RequestHandlerSelectors.basePackage("com.spring.studybyfirst.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        newArrayList(new ResponseMessageBuilder()
                                        .code(404)
                                        .message("404 api not found")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(406)
                                        .message("406 invalid parameter")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(500)
                                        .message("500 server message")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(503)
                                        .message("503 maintenance")
                                        .responseModel(new ModelRef("Error"))
                                        .build()))
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Spring Study",
                "스프링 전체 스터디를 위한 프로젝트",
                "Version 1.0",
                "개인 서비스",
                "gommpo111@gmail.com",
                "License all",
                "woolta.com");

    }
}
