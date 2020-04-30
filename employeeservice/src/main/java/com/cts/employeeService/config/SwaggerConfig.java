package com.cts.employeeService.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket EmployeeApi() {
    		return new Docket(DocumentationType.SWAGGER_2)
    		.select()
    		.apis(RequestHandlerSelectors.basePackage("com.cts.employeeService"))
    		.paths(regex("/login"))
    		.build()
    		.apiInfo(metaData());
}

    private ApiInfo metaData() {
    		return new ApiInfoBuilder()
    				.title("spring boot rest Api")
    				.description("Rest Api for employee managment")
    				.version("1.0.0")
    				.build();
    		
    }
    /*
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    		        registry.addResourceHandler("swagger-ui.html")
    		                .addResourceLocations("classpath:/META-INF/resources/");
    		        registry.addResourceHandler("/webjars/**")
    		                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }*/

}