package me.kktrkkt.springboot.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception {
        this.mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"kktrkkt\", \"password\":\"123\"}";
        this.mvc.perform(post("/users/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is(equalTo("kktrkkt"))))
                .andExpect(jsonPath("$.password", is(equalTo("123"))));
    }

    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"kktrkkt\", \"password\":\"123\"}";
        this.mvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        // accept에 따라 ContentNegotiatingViewResolver가 해당 미디어 타입으로 응답을 반환한다
                        .accept(MediaType.APPLICATION_XML)
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("kktrkkt"))
                .andExpect(xpath("/User/password").string("123"));
    }
}
