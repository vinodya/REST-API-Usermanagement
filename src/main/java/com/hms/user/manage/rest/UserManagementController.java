package com.hms.user.manage.rest;

import com.hms.user.manage.domain.User;
import com.hms.user.manage.repository.UserRepository;
import com.hms.user.manage.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserManagementController {

    @Autowired
    private UserRepository userRepositoryImpl;

    @GetMapping(value = "/user")
    public List<User> viewUsers() {
        return userRepositoryImpl.viewAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User input) {
        User user = new User(input.getUserId(), input.getUserName(), input.getUserPassword());
        userRepositoryImpl.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User input) {
        User user = new User(input.getUserId(), input.getUserName(), input.getUserPassword());
        userRepositoryImpl.editUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody User input) {
        userRepositoryImpl.deleteUser(input.getUserId());
    }
}

