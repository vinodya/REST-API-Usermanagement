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
        User user = new User(1, "vino", "jhfubf983");
        User newuser = userRepository.addUser(user);
        User testuser = (User) jdbcTemplate.queryForObject("select * from user where userid =" +
                user.getUserId(), BeanPropertyRowMapper.newInstance(User.class));
        Assert.assertEquals(newuser.getUserId(), testuser.getUserId());
        Assert.assertEquals(newuser.getUserName(), testuser.getUserName());
        Assert.assertEquals(newuser.getUserPassword(), testuser.getUserPassword());
    }

    @Test
    public void testDeleteUser(){
        int userId = 6;
        userRepository.deleteUser(userId);
        String sql ="select username from user where userid =" + userId;
        List<String> user = jdbcTemplate.queryForList(sql, String.class);
        if (user.isEmpty())
            user = null;
        Assert.assertNull(user);
    }

    @Test
    public void testViewAllUsers() {
        List<User> newuser = userRepository.viewAllUsers();
        List<User> testuser = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
       for (int i=0; i<newuser.size(); i++){
            Assert.assertEquals(newuser.get(i), testuser.get(i));
        }
    }

    @Test
    public void testgetUser(){
        int userId = 4;
        User newUser = userRepository.getUser(userId);
        String sql ="select * from user where userid =" + userId;
        User testUser =(User) jdbcTemplate.queryForObject(sql, new UserMapper());
        Assert.assertEquals(newUser.getUserName(), testUser.getUserName());
        Assert.assertEquals(newUser.getUserPassword(), testUser.getUserPassword());
    }

    @Test
    public void testEditUser(){
        User user =  new User(8, "vin", "ygevfh837");
        userRepository.addUser(user);
        User updateUser = new User(11, "vin", "urhgyh847");
        userRepository.editUser(updateUser);
        String sql ="select * from user where userid =" + updateUser.getUserId();
        User newUser =(User) jdbcTemplate.queryForObject(sql, new UserMapper());
        Assert.assertEquals(updateUser.getUserName(), newUser.getUserName());
        Assert.assertEquals(updateUser.getUserPassword(), newUser.getUserPassword());
    }



}