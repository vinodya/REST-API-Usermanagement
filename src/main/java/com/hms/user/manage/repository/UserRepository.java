package com.hms.user.manage.repository;

import com.hms.user.manage.domain.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(int userid);
    List<User> viewAllUsers();
}
