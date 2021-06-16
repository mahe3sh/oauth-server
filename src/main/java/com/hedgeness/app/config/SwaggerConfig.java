package com.hedgeness.app.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()                                  
          .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
          .build().securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(securityScheme()));
    }


    private SecurityScheme securityScheme() {
        return new BasicAuth("basicAuth");
    }
    private SecurityContext securityContext() {
        return SecurityContext.builder()

                .forPaths(postPaths())
                .build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/usermanagement/.*"), regex("/metadata/.*"),
                regex("/metadata/.*"),
                regex("/category/.*"),
                regex("/cl/.*"),
                regex("/aclentry/.*"),
                regex("/objidentity/.*"),
                regex("/dictionary/.*"),
                regex("/dictionarymetadata/.*"),
                regex("/policymanagement/.*"),
                regex("/productdatabase/.*"),
                regex("/producttemplate/.*"),
                regex("/producttype/.*"),
                regex("/rolemanagement/.*"),
                regex("/userVerification/.*"),
                regex("/userrolesmanagement/.*"));
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    @Bean
    public SecurityConfiguration security() {
    	//TODO: Swagger
        return SecurityConfigurationBuilder.builder()
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    	//return null;

    }
}