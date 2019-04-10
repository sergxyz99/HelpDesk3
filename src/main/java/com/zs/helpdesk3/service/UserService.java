package com.zs.helpdesk3.service;


import com.zs.helpdesk3.domain.User;

import java.util.Optional;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    Optional<User> findById(Long id);
}

