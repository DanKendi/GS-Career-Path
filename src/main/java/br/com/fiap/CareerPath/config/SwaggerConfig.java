package br.com.fiap.CareerPath.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "CareerPath",
                description = "API CareerPath 1.0"
        ),
        servers = {@Server(url = "http://localhost:8080",description = "LOCAL"),}
)

public class SwaggerConfig {
}
