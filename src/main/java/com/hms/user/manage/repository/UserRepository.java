package com.hms.user.manage.repository;

import com.hms.user.manage.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/**
 * UserRepository interface provides
 * the abstract methods where the
 * implementation of each provided
 * in the UserRepositoryImpl class
 *
 * @version 1.8
 * @author Vinodya Samarasinghe
 */
public interface UserRepository {
    /**
     * addUser for the user insertion into the database
     * using jdbcTemplate.update
     * @param user userId, userName, userPassword for user
     */
    User addUser(User user);

    /**
     * editUser for updating the user in the database
     * using jdbcTemplate.update
     * @param user userId, userName, userPassword for user
     */
    void editUser(User user);

    /**
     * deleteUser for deleting the user record in the
     * database using jdbcTemplate.update
     * @param userId unique user ID for user
     */
    void deleteUser(int userId);

    /**
     * viewAllUsers for viewing all the user records in the
     * database using jdbcTemplate.query
     */
    List<User> viewAllUsers();

    /**
     * getUser for finding particular user
     * when given the userId using jdbcTemplate.update
     */
    User getUser(int userId);
}

