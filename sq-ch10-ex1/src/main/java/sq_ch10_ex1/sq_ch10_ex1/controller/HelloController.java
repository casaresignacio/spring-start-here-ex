package sq_ch10_ex1.sq_ch10_ex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController is a combination of @ResponseBody and @Controller
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "Ciao!";
    }
}
