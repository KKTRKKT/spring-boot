package me.kktrkkt.springboot.external_config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "kktrkkt.name=sh2")
@TestPropertySource(locations = "/external_config/application.properties")
public class TestPropertiesTest {

    @Autowired
    private Environment environment;

    @Test
    public void test() {
        assertEquals("sh2", environment.getProperty("kktrkkt.name"));
    }
}
