package me.kktrkkt.springboot.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppRunner implements ApplicationRunner {
    @Autowired
    private String hello;

    @Autowired
    private Profile profile;

    @Autowired
    Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(hello);
        System.out.println(profile.getActive());
        System.out.println(profile.getContent());
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
    }
}
