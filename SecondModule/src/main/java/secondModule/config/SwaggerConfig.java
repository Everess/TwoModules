package secondModule.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import secondModule.controller.TestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class allows configure swagger
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = TestController.class)
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * Swagger API
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                /* .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/.*")) */

                /* Alternative - add classes for documentation */
                /* .apis(RequestHandlerSelectors.basePackage("secondModule"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo()); */

                .select()
                .apis(RequestHandlerSelectors.basePackage("secondModule"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Test swagger security
     * @return
     */
    /* @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    } */

    /**
     * Swagger meta info
     * @return
     */
    public ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "My custom swagger",
                null,
                "1.0",
                "Terms of Service",
                null,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/"
        );

        return apiInfo;
    }

    /**
     * Add redirect url
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs").setKeepQueryParams(true);
                registry.addRedirectViewController("/documentation/swagger-resources/configuration/ui",
                        "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/documentation/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
    }
}
