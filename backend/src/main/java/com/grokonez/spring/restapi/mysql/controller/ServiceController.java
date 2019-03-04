package com.grokonez.spring.restapi.mysql.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ServiceController {

    private static int counter = 0;

    // http://localhost:9080/api/retrieveServerTime
    @GetMapping("/retrieveServerTime")
    public String retrieveCurrentTime(){

        return "C: #" + counter++ + "-->"+LocalDateTime.now().toString();
    }
}
