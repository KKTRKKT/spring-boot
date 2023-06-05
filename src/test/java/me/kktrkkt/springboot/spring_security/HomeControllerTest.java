package me.kktrkkt.springboot.spring_security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    public void hello() throws Exception {
        this.mockMvc.perform(get("/hello")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(content().string(containsString("Hello")))
                .andDo(print());
    }

    @Test
    @WithMockUser
    public void my() throws Exception {
        this.mockMvc.perform(get("/my"))
                .andExpect(status().isOk())
                .andExpect(view().name("my"))
                .andExpect(content().string(containsString("My")))
                .andDo(print());
    }

}