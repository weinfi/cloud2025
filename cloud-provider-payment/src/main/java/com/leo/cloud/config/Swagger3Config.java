package com.leo.cloud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info().title("支付中心").version("1.0"))
                .externalDocs(new ExternalDocumentation().description("描述信息").url("http://localhost:8080"));
    }
}
