package com.ev.springMVC.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class MyController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname
                            , Model model) {
        model.addAttribute("message","hello"  + name +" "  + surname);
        System.out.println("hello " + name + " " + surname);
        return "first/hello_world";
    }

    @GetMapping("/good")
    public String goodBye() {
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a",required = false) int a,
                             @RequestParam(value = "b",required = false)int b,
                             @RequestParam(value = "command",required = false) String command,
                             Model model){
        double result;
        switch (command){
            case "addition":
                result=a+b;
                break;
            case "subtraction":
                result=a-b;
                break;
            case "division":
                result=a/b;
                break;
            default:
                result=0;
                break;
        }



        model.addAttribute("result",result);
       return "first/calculator";
    }
}
