package com.syncr.Syncr.Controller;

import com.syncr.Syncr.Models.users;
import com.syncr.Syncr.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

     @Autowired
     UserService userService;

    @PostMapping(path = "/register")
    public void registeruser(@RequestBody users user){
        userService.register(user);
    }


    @PostMapping(path = "/login")
    public String loginuser(@RequestBody users user){
        return userService.verify(user);
    }
}
