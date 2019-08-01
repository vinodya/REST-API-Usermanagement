package com.hms.user.manage.repository.impl;

import com.hms.user.manage.UserMapper;
import com.hms.user.manage.domain.User;
import com.hms.user.manage.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@SpringBootApplication(scanBasePackages = {"com.hms"})
@DisplayName("Test User Info Demo")
public class UserRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser(){
        User user = new User(13, "vino", "jhfubf983");
        User newUser = userRepository.addUser(user);
        User testUser = (User) jdbcTemplate.queryForObject("select * from user where userid =" +
                user.getUserId(), BeanPropertyRowMapper.newInstance(User.class));
        assertThat(newUser.getUserId()).isEqualByComparingTo(testUser.getUserId());
        assertThat(newUser.getUserName()).isEqualTo(testUser.getUserName());
        assertThat(newUser.getUserPassword()).isEqualTo(testUser.getUserPassword());
    }

    @Test
    public void testDeleteUser(){
        int userId = 6;
        userRepository.deleteUser(userId);
        String sql ="select username from user where userid =" + userId;
        List<String> user = jdbcTemplate.queryForList(sql, String.class);
        if (user.isEmpty())
            user = null;
        assertThat(user).isNull();
    }

    @RepeatedTest(2)
    public void testViewAllUsers() {
        List<User> newUser = userRepository.viewAllUsers();
        List<User> testUser = jdbcTemplate.query("select * from user",
                new BeanPropertyRowMapper<User>(User.class));
        if(newUser.size() == testUser.size()) {
            for (int i = 0; i < newUser.size(); i++) {
                assertThat(newUser.get(i).getUserId()).isEqualByComparingTo(testUser.get(i).getUserId());
                assertThat(newUser.get(i).getUserName().equals(testUser.get(i).getUserName())).isTrue();
                assertThat(newUser.get(i).getUserPassword().equals(testUser.get(i).getUserPassword())).isTrue();
            }
        } else {
            throw new RuntimeException("User viewing error");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 14 })
    public void testgetUser(int userId){
        User newUser = userRepository.getUser(userId);
        String sql ="select * from user where userid =" + userId;
        User testUser =(User) jdbcTemplate.queryForObject(sql, new UserMapper());
        assertThat(newUser.getUserName()).isEqualTo(testUser.getUserName());
        assertThat(newUser.getUserPassword()).isEqualTo(testUser.getUserPassword());
    }

    @Test
    public void testEditUser(){
        User user =  new User(14, "vin", "ygevfh837");
        userRepository.addUser(user);
        User updateUser = new User(14, "vin", "urhgyh847");
        userRepository.editUser(updateUser);
        String sql ="select * from user where userid =" + updateUser.getUserId();
        User newUser =(User) jdbcTemplate.queryForObject(sql, new UserMapper());
        assertThat(newUser.getUserName()).isEqualTo(updateUser.getUserName());
        assertThat(newUser.getUserPassword()).isEqualTo(updateUser.getUserPassword());
    }
}