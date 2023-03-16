package com.ev.springMVC.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class MyController {
    @GetMapping("/hello")
    public String sayHello(){
        return "first/hello_world";
    }
@GetMapping("/good")
    public String goodBye(){
        return "first/goodbye";
    }
}
