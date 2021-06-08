package com.example.Jwtauthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestApis {

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess(){
        return ">>> User Contents!";
    }

    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Board Management Project!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }
}
