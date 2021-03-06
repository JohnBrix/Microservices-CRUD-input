package com.example.observable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class ObservableApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservableApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Microservices 1 Documentation")
                .description(
                        "Microservices 1 API Documentation")
                .termsOfServiceUrl("").version("1.0.1").contact(new Contact("John", "https://www.abc.com/", "john.pomoy@collabera.com")).build();
    }
}
