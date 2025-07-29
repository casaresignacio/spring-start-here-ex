package com.example.sq_ch9_ex2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

//@Service stereotype annotation to instruct Spring
// to manage this class as a bean in its context.
@Service
//@SessionsScope annotation to change the scope of the bean to session
@SessionScope
public class LoggedUserManagementService {

    private String username;

    public LoggedUserManagementService() {
        // Constructor vacío para que Spring pueda crear el bean
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}