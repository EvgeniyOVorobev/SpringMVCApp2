package com.ev.springMVC.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class MyController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "surname",required = false) String surname){

        System.out.println("hello "+name+" "+surname);
        return "first/hello_world";
    }
@GetMapping("/good")
    public String goodBye(){
        return "first/goodbye";
    }
}
