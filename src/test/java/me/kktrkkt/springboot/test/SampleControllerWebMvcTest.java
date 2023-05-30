package me.kktrkkt.springboot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// slice test로 통합테스트보다 가볍다. WebMvcTest는 controller 단의 빈들을 제외하고 다른 빈들의 주입을 차단한다.
@WebMvcTest
class SampleControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SampleService mockSampleService;

    @Test
    void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("shlee");

        this.mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello shlee"))
                .andDo(print());
    }
}