package me.kktrkkt.springboot.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private HttpSecurity httpSecurity;

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/hello").setViewName("hello");
//    }

    // 참고 SpringBootWebSecurityConfiguration -> SpringBootWebSecurityConfiguration -> SecurityFilterChainConfiguration()
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/hello").permitAll()
                .anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
        return http.build();
    }
}
