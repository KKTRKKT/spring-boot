package me.kktrkkt.springboot.external_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private KktrkktProperties kktrkktProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(kktrkktProperties.getName());
        System.out.println(kktrkktProperties.getAge());
        System.out.println(kktrkktProperties.getHeight());
    }
}
