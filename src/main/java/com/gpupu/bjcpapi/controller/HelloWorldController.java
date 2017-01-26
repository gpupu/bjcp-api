package com.gpupu.bjcpapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
 
    @RequestMapping("/helloWorld")
    public String hello(Model model) {
        
        model.addAttribute("greeting", "Hello World");
        
        return "helloworld";
        
    }
    
    @RequestMapping("/helloFriend")
    public String helloFriend(Model model) {
        
        model.addAttribute("greeting", "Hello my friend");
        
        return "helloworld";
        
    }
 
}