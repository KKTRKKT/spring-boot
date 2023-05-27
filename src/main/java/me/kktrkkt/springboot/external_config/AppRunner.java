package me.kktrkkt.springboot.external_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Value("${kktrkkt.name}")
    private String name;

    @Value("${kktrkkt.age}")
    private int age;

    @Value("${kktrkkt.height}")
    private int height;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(name);
        System.out.println(age);
        System.out.println(height);
    }
}
