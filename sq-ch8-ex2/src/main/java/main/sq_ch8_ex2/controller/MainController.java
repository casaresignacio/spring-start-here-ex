package main.sq_ch8_ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home (
        // We define a new parameter for the controller's action method and
        // annotate it with @RequestParam
        @RequestParam String color,
        //add the Model parameter to send data from the controller to the view
        Model page
    ){
        page.addAttribute("username", "katy");
        //controller passes the color sent by the client to the view
        page.addAttribute("color", color);
        return "home.html";
    }
}
