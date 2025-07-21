package com.syncr.Syncr.Service;


import com.syncr.Syncr.Models.users;
import com.syncr.Syncr.Repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Autowired
    private jwtService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private AuthenticationManager authenticationManager;

    public void register(users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDetailsRepo.save(user);

    }

    public String verify(users user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else{
            return "fail";
        }
    }
}
