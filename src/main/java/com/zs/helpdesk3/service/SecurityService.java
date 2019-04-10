package com.zs.helpdesk3.service;

import com.zs.helpdesk3.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(HttpServletRequest request, String username, String passwordConfirm);

    String getCurrentUserName();
    User getCurrentUser();
}
