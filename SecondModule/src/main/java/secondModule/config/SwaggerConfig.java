package secondModule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class SwaggerConfig {

    /**
     * Swagger API
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // .apis(RequestHandlerSelectors.any())
                // .paths(PathSelectors.regex("/pricing.*"))

                /* Alternative - add classes for documentation*/
                .apis(RequestHandlerSelectors.basePackage("twoModules"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    /**
     * Test swagger security
     * @return
     */
    @Bean
    /* public SecurityConfiguration security() {
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
}
