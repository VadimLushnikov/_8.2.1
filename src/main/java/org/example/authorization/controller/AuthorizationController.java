package org.example.authorization.controller;

import jakarta.validation.Valid;
import org.example.authorization.Authorities;
import org.example.authorization.User;
import org.example.authorization.service.AuthorizationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;
    public AuthorizationController(AuthorizationService service){
        this.service=service;
    }

//    @GetMapping("/authorize")
//    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
//        return service.getAuthorities(user, password);
//    }
    @GetMapping("/authorize")
    public List<Authorities> getAuthoritiesList(@Valid User user) {
        System.out.println(user);
        return service.getAuthoritiesList(user);
    }
}