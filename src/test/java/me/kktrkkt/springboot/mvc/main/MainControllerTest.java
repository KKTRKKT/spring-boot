package me.kktrkkt.springboot.mvc.main;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebClient webClient;

    @Test
    public void main() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("name", "kktrkkt"))
                .andExpect(content().string(containsString("kktrkkt")))
                .andDo(print());
    }

    @Test
    public void main_html() throws IOException {
        HtmlPage page = webClient.getPage("/");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertTrue(h1.getTextContent().equalsIgnoreCase("kktrkkt"));
//        DomNodeList<HtmlElement> h1 = page.getBody().getElementsByTagName("h1");
//        assertNotNull(h1.get(0));
//        assertTrue(h1.get(0).getTextContent().equalsIgnoreCase("kktrkkt"));

    }
}