package com.simpleSBApps.jpaboilerplate.services;

import com.simpleSBApps.jpaboilerplate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public List<User> findAllByOrderByRoleAscUsernameAsc();

}
