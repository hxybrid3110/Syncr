package com.syncr.Syncr.Controller;

import com.syncr.Syncr.Models.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

    @GetMapping(path = "/")
    public String hello(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ("Hello"+userPrincipal.getUser().getUsername());
    }


}
