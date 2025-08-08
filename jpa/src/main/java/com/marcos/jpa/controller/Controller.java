package com.marcos.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestMapping;


@RestController
@RequestMapping("/api/v1")
public class Controller{

    @GetMapping
    public String hello(){
        return "Hello, World";
    }
}