package me.kktrkkt.springboot.rest_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class})
public class Application {

    private final String CONTEXT_URI = "http://localhost:8080";

    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {
        return restTemplate -> {
            restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(CONTEXT_URI, restTemplate.getUriTemplateHandler()));
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        };
    }

    @Bean
    public WebClientCustomizer webClientCustomizer() {
        return webClientBuilder -> webClientBuilder.baseUrl(CONTEXT_URI);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
