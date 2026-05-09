package com.example.SpringBootDockerIntegration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public  String hello(){
        return "Spring Docker integration success";
    }
}
