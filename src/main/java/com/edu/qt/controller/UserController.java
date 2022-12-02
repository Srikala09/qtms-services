package com.edu.qt.controller;

import com.edu.qt.dto.StudentDTO;
import com.edu.qt.dto.UserDTO;
import com.edu.qt.model.Student;
import com.edu.qt.model.User;
import com.edu.qt.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.String;

import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    UserDTO userDTO;
    ModelMapper modelMapper = new ModelMapper();

    public UserController() {
    }

 //  @GetMapping(value = "/user/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
     @GetMapping(value = "/user/all", produces = "application/json")
    public List<UserDTO> fetchAllUsers() {
       System.out.println("In controller...");
       List<User> UsersList = userService.fetchAllUsers();
       List<UserDTO> Users = Arrays.asList(modelMapper.map(UsersList,UserDTO[].class));
       return Users ;
   }

    @GetMapping(value = "/user/name/{username}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> fetchUsersByName(@PathVariable("username") String name) {
        System.out.println("Fetching Users by name ...");
        List<User> UsersList = this.userService.fetchUsersByName(name);
        List<UserDTO> userDTO = Arrays.asList(modelMapper.map(UsersList,UserDTO[].class));
        return userDTO;
    }

    @PostMapping(value = "/user/create",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        //this.userDTO = userDTO;
        System.out.println("name of the user=="+userDTO.getName());
        User user=modelMapper.map(userDTO,User.class);
        userService.persistUser(user);
        return ResponseEntity.ok().body("User registered successfully.");
    }
   /* private User  generateUser(UserDTO userDTO,User user) {
        user.setCourse(userDTO.getName());
        .setEmail(studentDTO.getEmail());
        student.setMobile(studentDTO.getMobile());
        student.setStatus(studentDTO.getStatus());
        student.setName(studentDTO.getName());
        return student ;
    }*/

}
