package com.mewhz.moments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartController {

    @GetMapping("/")
    public String heart() {
        return "Hello World!";
    }

}
