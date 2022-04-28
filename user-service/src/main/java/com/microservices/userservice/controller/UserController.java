package com.microservices.userservice.controller;

import com.microservices.userservice.VO.ResponseWithUserDepartment;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
    log.info("Inside saveUser method in UserController");
    return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseWithUserDepartment getUserWithDepartment(@PathVariable("id") long userId){
        log.info("Inside getUserWithDepartment method in UserController");
        return userService.getUserWithDepartment(userId);
    }
}
