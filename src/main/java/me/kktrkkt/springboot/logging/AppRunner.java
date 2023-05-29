package me.kktrkkt.springboot.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    Logger debugger = LoggerFactory.getLogger(AppRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //logging 레벨이 debug 레벨에서만 출력
        debugger.debug("hi");
    }
}
