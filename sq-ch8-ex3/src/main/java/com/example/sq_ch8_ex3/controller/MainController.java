package com.example.sq_ch8_ex3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String home(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            Model page) {
        //sends the name parameter's value to the view
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }
}
