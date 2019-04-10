package com.zs.helpdesk3.repository;

import com.zs.helpdesk3.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
