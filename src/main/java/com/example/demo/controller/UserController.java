package com.example.demo.controller;

import com.example.demo.aop.annotation.NameAuth;
import com.example.demo.bean.UserDto;
import com.example.demo.bean.ZoomList;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return service.getAllUsers();

    }


    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@Valid @RequestBody UserDto user){
       ResponseEntity<User> response=service.addUser(user);
       log.info("response from service to controller="+response);
       return response;
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<User> fetchUser(@PathVariable long id){
        return service.getUser(id);
    }

    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }

    @GetMapping("/get-user/{id}/{name}")
    public ResponseEntity<User> fetchUserWithIdName(@PathVariable long id,@PathVariable String name){
        return service.fetchUserWithIdName(id,name);
    }

    RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/zoom/data")
    public ZoomList getData(@RequestHeader(value = "Authorization") HttpHeaders header) throws JsonProcessingException {
        HttpEntity<String> httpEntity=new HttpEntity<>("parameters",header);
         ResponseEntity<ZoomList> response=restTemplate.exchange("https://api.zoom.us/v2/users", HttpMethod.GET,httpEntity,ZoomList.class);
        return response.getBody();


    }
}
