package com.example.demo.service.impl;

import com.example.demo.bean.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.CustomExceptionHandler;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository repository;


    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    public ResponseEntity<User> addUser(UserDto userDto) {
        User user=modelMapper.map(userDto,User.class);
//        User user = new User();
//        user.setName(userDto.getName());
//        user.setDob(userDto.getDob());

        User userResponse=repository.save(user);
        log.info("user response from db to service="+userResponse.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    public ResponseEntity<User> getUser(long id) {
        Optional<User> user=repository.findById(id);
        if(user.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        throw new NotFoundException("id="+id+" is invalid");
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    public ResponseEntity<?> deleteUser(long id) {
        Optional<User> user=repository.findById(id);
        if(user.isPresent()) {
            repository.delete(user.get());
            return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<User> fetchUserWithIdName(long id,String name){
        User user=repository.findByIdName(id,name);

        return ResponseEntity.status(HttpStatus.OK).body(user);

    }
}
