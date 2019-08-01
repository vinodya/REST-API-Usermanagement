package com.hms.user.manage.repository.impl;

import com.hms.user.manage.domain.User;
import com.hms.user.manage.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User addUser(User user) {
        String sql = "INSERT INTO user (userid, username, userpassword) VALUES (?, ?, ?)";
        try {
            if (!isUserIdExist(user.getUserId())) {
                jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getUserPassword());
                logger.info("User {} successfully inserted", user.getUserId());
                return user;
            } else {
                throw new RuntimeException("Userid exist, please enter the correct userid");
            }
        } catch (DataAccessException e) {
            logger.error("Error occurred while adding user", e);
            return null;
        }
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE userid=?";
        try {
            if (isUserIdExist(userId)) {
                jdbcTemplate.update(sql, userId);
                logger.info("User {} successfully deleted", userId);
            } else {
                throw new RuntimeException("No such userid exist");
            }
        } catch (DataAccessException e) {
            logger.error("Error occurred while deleting the user", e);
        }
    }

    public Boolean isUserIdExist(int userId) {
        String sql = "SELECT username FROM user WHERE userid="+userId;
        List<User> user = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
        if (user.size() != 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<User> viewAllUsers() {
        String sql = "SELECT * FROM user";
        try {
            List<User> user = jdbcTemplate.query(sql, new ResultSetExtractor<List<User>>(){
                @Override
                public List<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    List<User> list = new ArrayList<User>();
                    if (!resultSet.next()) {
                        throw new RuntimeException("No such userid exist");
                    } else {
                        do{
                            User user = new User();
                            user.setUserId(resultSet.getInt("userid"));
                            user.setUserName(resultSet.getString("username"));
                            user.setUserPassword(resultSet.getString("userpassword"));
                            list.add(user);
                        }while (resultSet.next());
                        logger.info("All users displayed");
                        return list;
                    }
                }
            });
            return user;
        } catch (DataAccessException e) {
            logger.error("Error occurred while viewing the user", e);
            return null;
        }
    }
    @Override
    public User getUser(int userId) {
        String sql = "SELECT * FROM user where userid="+userId;
        try {
            if (isUserIdExist(userId)) {
                User user = (User) jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class));
                logger.info("User {} details found", userId);
                return user;
            } else {
                throw new RuntimeException("No such userid exist");
            }
        } catch (DataAccessException e) {
            logger.error("Error occurred while finding the user", e);
            return  null;
        }
    }
    @Override
    public void editUser(User user) {
        String sql = "UPDATE user SET username=?, userpassword=? WHERE userid=?";
        try {
            if (isUserIdExist(user.getUserId())) {
                jdbcTemplate.update(sql, user.getUserName(), user.getUserPassword(), user.getUserId());
                logger.info("User {} successfully updated", user.getUserId());
            } else {
                throw new RuntimeException("User not present");
            }
        } catch (DataAccessException e) {
            logger.error("Error occurred while updating the user", e);
        }
    }
}