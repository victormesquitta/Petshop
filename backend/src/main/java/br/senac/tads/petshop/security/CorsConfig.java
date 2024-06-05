package br.senac.tads.petshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite qualquer origem (ajuste para produção)
                        .allowedOrigins("http://localhost:5173", "http://localhost:8080") // Permita somente a origem do seu frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(true); // Necessário se estiver usando cookies
            }
        };
    }
}
