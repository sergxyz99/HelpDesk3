package com.zs.helpdesk3;

import com.zs.helpdesk3.domain.User;
import com.zs.helpdesk3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class GlobalVar {
    @Autowired
    UserRepository userRepository;
    public static User currentUser;
    public void setCurrentUser(User user){
        currentUser=user;
    }

    public void setCurrentUser(){
        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication();//.getPrincipal();
        System.out.println(principal.getName());
        currentUser=userRepository.findByUsername(principal.getName());
        System.out.println("currentUser: "+currentUser);
        }

    public static User getCurrentUser() {
        return currentUser;
    }
}
