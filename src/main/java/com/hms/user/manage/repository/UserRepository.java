package com.hms.user.manage.repository;

import com.hms.user.manage.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(int userid);
    List<User> viewAllUsers();
}
