package com.hms.user.manage;

import com.hms.user.manage.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("userid"));
        user.setUserName(resultSet.getString("username"));
        user.setUserPassword(resultSet.getString("userpassword"));
        return user;
    }
}
