package com.example.demo.game;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

@Bean
    public String name(){
        return "arshad";
    }
}
