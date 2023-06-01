package me.kktrkkt.springboot.mvc.hateoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HateoasController {

    @GetMapping("/hateoas")
    @Hateoas
    public HateoasResponse hateoas() {
        return new HateoasResponse("prefix", "text");
    }
}
