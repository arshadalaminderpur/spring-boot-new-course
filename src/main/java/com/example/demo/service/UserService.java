package com.example.demo.service;

import com.example.demo.bean.UserDto;
import com.example.demo.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<List<User>> getAllUsers();
    public ResponseEntity<User> addUser(UserDto userDto);
    public ResponseEntity<User> getUser(long id);
    public ResponseEntity<?> deleteUser(long id);

    ResponseEntity<User> fetchUserWithIdName(long id,String name);
}
