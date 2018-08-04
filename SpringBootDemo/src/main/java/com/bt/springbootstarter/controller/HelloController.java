package com.bt.springbootstarter.controller;

import com.bt.springbootstarter.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "/hello")
    public String hello(){
        return "Hi";
    }

    @GetMapping(path = "/hello-bean")
    public HelloWorldBean helloBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-bean-internationalization")
    public HelloWorldBean helloBeanInternationalization(){
        return new HelloWorldBean("Good Morning...");
    }
}
