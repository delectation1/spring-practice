package org.example.sqch9.controllers;

import org.example.sqch9.processors.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //dont need to change scope for this class as it does not store details in its fields
public class LoginController {

    @Autowired
    private LoginProcessor loginProcessor;

    @GetMapping("/")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();

        if (loggedIn) {
            return "redirect:/main";
        }

        model.addAttribute("message", "Login failed");
        return "login";
    }
}