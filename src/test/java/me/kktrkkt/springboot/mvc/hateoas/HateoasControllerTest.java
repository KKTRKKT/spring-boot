package me.kktrkkt.springboot.mvc.hateoas;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HateoasController.class)
@Import(HateoasAspect.class)
class HateoasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hateoas() throws Exception {
        this.mockMvc.perform(get("/hateoas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prefix").value("prefix"))
                .andExpect(jsonPath("$.text").value("text"))
                .andExpect(jsonPath("$.links[0].rel").value("self"))
                .andDo(print());
    }

}