package me.kktrkkt.springboot.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
    * 기본 리소스 경로
    * classpath:/static
    * classpath:/public
    * classpath:/resources/
    * classpath:/META-INF/resources
    * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 정적 리소스 매핑 커스터마이징, properties 설정보다 추천
        registry.addResourceHandler("/mvc/static/**") // 리소스를 핸들할 url 설정
                .addResourceLocations("classpath:/mvc/static/")  // 리소스가 존재하는 경로
                .setCachePeriod(20); // 캐싱 유지 시간(초)
    }
}
