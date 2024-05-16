package org.example.sqch8;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
//    @RequestMapping("/home")
//    public String home(Model page) {
//        page.addAttribute("color", "red");
//        page.addAttribute("username", "Test");
//        page.addAttribute("age", 25);
//        return "home";
//    }
//    @RequestMapping("/home") // Request Parameter
//    public String home(
//            @RequestParam(required = false) String color,
//            Model page) {
//        page.addAttribute("color", color);
//        page.addAttribute("username", name);
//        return "home";
//    }
    @RequestMapping("/home/{color}") // Path variable
    public static String home(
            @PathVariable String color, // name must be same as name of var in path
            Model page) {
        page.addAttribute("username", "Test");
        page.addAttribute("color", color);
        return "home";
    }
}