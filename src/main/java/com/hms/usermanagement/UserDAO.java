package com.hms.usermanagement;

import java.util.List;

public interface UserDAO  {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(int userid);
    List<User> viewAllUsers();
}
