package com.syncr.Syncr.Service;

import com.syncr.Syncr.Models.UserPrincipal;
import com.syncr.Syncr.Models.users;
import com.syncr.Syncr.Repo.UserDetailsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        users user = userDetailsRepo.findByUsername(username);

        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }else{
            return new UserPrincipal(user);
        }


    }
}