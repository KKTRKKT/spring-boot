package me.kktrkkt.springboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// webEnvironment 값을 DEFINED_PORT 또는 RANDOM_PORT로 설정하면 톰캣서버가 구동된다.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
class SampleControllerRandomPortTest {

    @Autowired
    private TestRestTemplate template;

    // 해당 변수는 Mock객체가 된다.
    @MockBean
    private SampleService mockSampleService;

    @Autowired
    // 논블로킹 방식의 http client
    private WebTestClient webTestClient;

    @Test
    void hello() {
        when(mockSampleService.getName()).thenReturn("shlee");

        String result = this.template.getForObject("/hello", String.class);
        assertEquals("hello shlee", result);
    }

    @Test
    void helloFlux() {
        when(mockSampleService.getName()).thenReturn("shlee");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello shlee")
                .value(System.out::println);
    }
}