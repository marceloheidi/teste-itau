package com.itau.teste.br.teste.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(Arrays.asList("application/json"));

    @Bean
    public Docket swaggerSpringView() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itau.teste.br.teste"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);

    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("Teste Itaú Caixa Eletrônico")
                .version("v1")
                .build();
    }
}
