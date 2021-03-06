package com.bt.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootStarter {
    public static void main(String args[]){
        SpringApplication.run(SpringBootStarter.class,args);
    }

    @RestController
    @RequestMapping("/api")
    public class ApiController{
        @GetMapping("/greeting")
        public String getGreeting(){
            return "Hello World from API";
        }
    }
}
