package com.zs.helpdesk3.repository;

import com.zs.helpdesk3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findById(long Id);
}
