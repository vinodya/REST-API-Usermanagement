package com.hms.user.manage.repository.impl;

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
    public void testAddUaser(){
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
        int userId = 11;
        //userRepository.deleteUser(userId);
        String user3 = (String) jdbcTemplate.queryForObject("select username from user where userid ="+
                        userId, String.class);
        System.out.println(user3);
        //Assert.assertEquals(null, user2);
        //Assert.assertEquals(null, user2.getUserName());
        //Assert.assertEquals(null, user2.getUserPassword());
    }

    @Test
    public void testAddaUser(){
        User user = new User(12, "vino", "jhfubf983");
        User user1 = userRepository.addUser(user);
        User user2 = (User) jdbcTemplate.queryForObject("select * from user where userid =" +
                user.getUserId(), BeanPropertyRowMapper.newInstance(User.class));
        Assert.assertEquals(user1.getUserId(), user2.getUserId());
        Assert.assertEquals(user1.getUserName(), user2.getUserName());
        Assert.assertEquals(user1.getUserPassword(), user2.getUserPassword());
    }

    @Test
    public void testAdddUser(){
        User user = new User(12, "vino", "jhfubf983");
        User user1 = userRepository.addUser(user);
        User user2 = (User) jdbcTemplate.queryForObject("select * from user where userid =" +
                user.getUserId(), BeanPropertyRowMapper.newInstance(User.class));
        Assert.assertEquals(user1.getUserId(), user2.getUserId());
        Assert.assertEquals(user1.getUserName(), user2.getUserName());
        Assert.assertEquals(user1.getUserPassword(), user2.getUserPassword());
    }
}