package com.hms.user.manage.repository.impl;

import com.hms.user.manage.UserMapper;
import com.hms.user.manage.domain.User;
import com.hms.user.manage.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest()
@SpringBootApplication(scanBasePackages = {"com.hms"})
public class UserRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser(){
        User user = new User(12, "vino", "jhfubf983");
        User user1 = userRepository.addUser(user);
        User user2 = (User) jdbcTemplate.queryForObject("select * from user where userid =" +
                user.getUserId(), BeanPropertyRowMapper.newInstance(User.class));
        Assert.assertEquals(user1.getUserId(), user2.getUserId());
        Assert.assertEquals(user1.getUserName(), user2.getUserName());
        Assert.assertEquals(user1.getUserPassword(), user2.getUserPassword());
    }

    @Test
    public void testDeleteUser(){
        int userId = 6;
        userRepository.deleteUser(userId);
        String sql ="select username from user where userid =" + userId;
        List<String> user = jdbcTemplate.queryForList(sql, String.class);
        if (user.isEmpty())
            user = null;
        Assert.assertEquals(null, user);
    }

    @Test
    public void testViewAllUsers() {
        List<User> user1 = userRepository.viewAllUsers();
        List<User> user2 = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        Assert.assertEquals(user1.size(), user2.size());
    }

    @Test
    public void testgetUser(){
        int userId = 4;
        User user1 = userRepository.getUser(userId);
        String sql ="select * from user where userid =" + userId;
        User user2 =(User) jdbcTemplate.queryForObject(sql, new UserMapper());
        Assert.assertEquals(user1.getUserName(), user2.getUserName());
        Assert.assertEquals(user1.getUserPassword(), user2.getUserPassword());
    }

    @Test
    public void testEditUser(){
        User user =  new User(4, "vin", "ygevfh837");
        userRepository.editUser(user);
        String sql ="select * from user where userid =" + user.getUserId();
        User user1 =(User) jdbcTemplate.queryForObject(sql, new UserMapper());
        Assert.assertEquals(user.getUserName(), user1.getUserName());
        Assert.assertEquals(user.getUserPassword(), user1.getUserPassword());
    }



}