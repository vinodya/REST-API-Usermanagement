package com.hms.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserManagementController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/user")
    public List<User> viewUsers() {

        return userRepository.viewAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User input) {
        User user = new User(input.getUserId(), input.getUserName(), input.getUserPassword());
        userRepository.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User input) {
        User user = new User(input.getUserId(), input.getUserName(), input.getUserPassword());
        userRepository.editUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody User input) {
        userRepository.deleteUser(input.getUserId());
    }
}

