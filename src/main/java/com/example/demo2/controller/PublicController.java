package com.example.demo2.controller;

import com.example.demo2.entity.User;
import com.example.demo2.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserEntryService userEntryService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping("/addUser")
    public void createUser(@RequestBody User user){
        userEntryService.saveNewUser(user);
    }
}
