package me.kktrkkt.springboot.spring_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AppRunner implements ApplicationRunner {

    @Autowired
    ApplicationArguments arguments;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // VM option : -Dfoo=1
        System.out.println("foo:"+arguments.containsOption("foo"));
        // program arguments : --bar=2
        System.out.println("bar:"+arguments.containsOption("bar"));
        // program arguments만 ApplicationArguments에 등록된다
    }
}
