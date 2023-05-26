package me.kktrkkt.springboot.external_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* 프로퍼티 우선 순위
* 1. 유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties
* 2. 테스트에 있는 @TestPropertySource
* 3. @SpringBootTest 애노테이션의 properties 애트리뷰트
* 4. 커맨드 라인 아규먼트
* 5. SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는 프로퍼티
* 6. ServletConfig 파라미터
* 7. ServletContext 파라미터
* 8. java:comp/env JNDI 애트리뷰트
* 9. System.getProperties() 자바 시스템 프로퍼티
* 10. OS 환경 변수
* 11. RandomValuePropertySource
* 12. JAR 밖에 있는 특정 프로파일용 application properties
* 13. JAR 안에 있는 특정 프로파일용 application properties
* 14. JAR 밖에 있는 application properties
* 15. JAR 안에 있는 application properties
* 16. @PropertySource
* 17. 기본 프로퍼티 (SpringApplication.setDefaultProperties)
*
* application.properties 우선 순위
* 1. file:./config/
* 2. file:./
* 3. classpath:/config/
* 4. classpath:/
 * */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
