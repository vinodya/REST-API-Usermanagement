package com.hms.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO user (userid, username, userpassword) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getUserPassword());
            System.out.println("User " + user.getUserId() + " successfully inserted");
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userid) {
        try {
            String sql = "DELETE  FROM user WHERE userid=?";
            jdbcTemplate.update(sql, userid);
            System.out.println("User id "+ userid +" successfully deleted");
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> viewAllUsers() {
        try {
            String sql = "SELECT * FROM user";
            List<User> user = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void editUser(User user) {
        try {
            String sql = "UPDATE user SET username=?, userpassword=? WHERE userid=?";
            jdbcTemplate.update(sql, user.getUserName(), user.getUserPassword(), user.getUserId());
            System.out.println("User Id "+user.getUserId()+" password successfully updated");
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
