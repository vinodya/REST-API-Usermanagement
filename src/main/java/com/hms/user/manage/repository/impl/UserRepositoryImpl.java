package com.hms.user.manage.repository.impl;

import com.hms.user.manage.domain.User;
import com.hms.user.manage.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO user (userid, username, userpassword) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getUserPassword());
            logger.info("User " + user.getUserId() + " successfully inserted");
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userid) {
        try {
            String sql = "DELETE  FROM user WHERE userid=?";
            jdbcTemplate.update(sql, userid);
            logger.info("User "+ userid +" successfully deleted");
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<User> viewAllUsers() {
        try {
            String sql = "SELECT * FROM user";
            List<User> user = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
            logger.info("All users displayed");
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void editUser(User user) {
        try {
            String sql = "UPDATE user SET username=?, userpassword=? WHERE userid=?";
            jdbcTemplate.update(sql, user.getUserName(), user.getUserPassword(), user.getUserId());
            logger.info("User "+user.getUserId()+" successfully updated");
        } catch (DataAccessException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
