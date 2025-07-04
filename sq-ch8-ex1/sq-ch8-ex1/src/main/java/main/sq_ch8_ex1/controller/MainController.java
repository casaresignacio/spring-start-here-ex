package main.sq_ch8_ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// the @Controller stereotype annotation marks this class as Spring MVC controller
// and adds a bean of this type to the Spring context
@Controller
public class MainController {

    //Assign the controller's action to an HTTP request path
    @RequestMapping("/home")
    //the action method defines a parameter of type Model that stores the data the controller sends to the view
    public String home(Model page) {
        //We add the data we want the controller to send to the view.
        page.addAttribute("username","Katy");
        page.addAttribute("color", "red");
        //The controller's action return the view to be rendered onto the HTP response.
        return "home.html";
    }

}
