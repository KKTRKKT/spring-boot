package me.kktrkkt.springboot.mvc.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {

    @GetMapping("/error_page")
    public String errorPage(){
        throw new ErrorException();
    }

    @ExceptionHandler(ErrorException.class)
    public @ResponseBody ErrorMessage handler(ErrorException e) {
        return new ErrorMessage(this.getClass().getName()+" occur error", "IDXIDXIDX");
    }
}
