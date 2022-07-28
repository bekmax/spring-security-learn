package com.springsecuritylearn.service;

import com.springsecuritylearn.domain.Role;
import com.springsecuritylearn.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
