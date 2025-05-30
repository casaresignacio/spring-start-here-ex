package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//add the Controller stereotype annotation
@Controller
public class MainController {

    //associate the action with an HTTP request path
    @RequestMapping("/home")
    public String home() {
        //return the HTML document name that contains the details we want the browser to display
        return "home.html";
    }
}
