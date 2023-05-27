package me.kktrkkt.springboot.spring_application;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // // program arguments만 등록
        System.out.println(Arrays.toString(args));
        new SpringApplicationBuilder()
                .sources(Application.class)
                // 리스너는 context 설정 전이므로 bean 등록 불가능
                .listeners((ApplicationListener<ApplicationStartingEvent>)
                        event -> System.out.println("ApplicationStartedEvent"))
                // spring mvc 기본값, 가장먼저 체크하는 조건
                .web(WebApplicationType.SERVLET)
                // webflux 기본값
//                .web(WebApplicationType.REACTIVE)
                // 리소스에 있는 배너 파일이 더 우선순위가 높다
                .banner(new Banner() {
                    @Override
                    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                        out.println("=========================");
                        out.println("new Banner");
                        out.println("=========================");
                    }
                })
                .run(args);
    }
}
