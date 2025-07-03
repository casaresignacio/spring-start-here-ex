package sq_ch8_ex4.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //To define a path variable, you assign it a name and put it the path between curly braces
    @RequestMapping("/home/{color}")
    public String home (
            //The name of the parameter must be the same as the name of the variable in the path
            @PathVariable String color,
            Model page ) {
        page.addAttribute("username", "katy");
        page.addAttribute("color",color);
        return "home.html";
    }
}
