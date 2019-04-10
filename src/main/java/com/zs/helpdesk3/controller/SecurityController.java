package com.zs.helpdesk3.controller;

import com.zs.helpdesk3.domain.User;
import com.zs.helpdesk3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class SecurityController {
@Autowired
UserRepository userRepository;
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public User currentUser() {
        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(principal.getName());
        return (userRepository.findByUsername(principal.getName()));
//        return null;
    }
}

