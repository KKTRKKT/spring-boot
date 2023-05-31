package me.kktrkkt.springboot.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(OutputCaptureExtension.class)
public class OutputCaptureTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void testName(CapturedOutput output) {
        System.out.println("Hello World");
        logger.info(() ->"logger info");

        assertTrue(output.toString().contains("Hello World"));
        assertTrue(output.toString().contains("logger info"));
    }
}
