package org.example.sqch9.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import org.example.sqch9.services.*;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    @Autowired
    public LoginProcessor(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }
    public boolean login() {
        loginCountService.increment();

        String username = this.getUsername();
        String password = this.getPassword();

        if (username.equals("test") && password.equals("password")) {
            loggedUserManagementService.setUsername(username);
            return true;
        }

        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}