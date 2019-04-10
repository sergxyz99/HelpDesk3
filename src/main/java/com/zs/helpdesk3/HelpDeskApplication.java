package com.zs.helpdesk3;

import com.zs.helpdesk3.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class HelpDeskApplication extends SpringBootServletInitializer {
    @Autowired
    GlobalVar globalVar;
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
    public static void main(String[] args) {
        SpringApplication.run(HelpDeskApplication.class, args);
    }

    public void run(String... args) throws Exception {
        globalVar.setCurrentUser();
    }
}