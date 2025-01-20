package Animals.first.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My API")
                        .version("0.2")
                        .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                        .contact(new Contact()
                                .name("Kacper S")
                                .url("http://example.com")
                                .email("your.email@example.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Full API Documentation")
                        .url("http://example.com/docs"));
    }
}