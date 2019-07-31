package com.hms.user.manage.domain;

import org.springframework.stereotype.Component;

/**
 *  User class is the main entity.
 *  This class contains 3 properties
 *  with constructors and setter and getters.
 *
 * @version 1.8
 * @author Vinodya Samarasinghe
 */
@Component
public class User  {

    /**
     * The id of the user
     */
    private int userId;
    /**
     * The name of the user
     */
    private String userName;
    /**
     * The password of the user
     */
    private String userPassword;

    /**
     * The User constructor to get all parameters
     * @param userId the unique user ID
     * @param userName the name of the user
     * @param userPassword the password of the user
     *
     */
    public User(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    /**
     * The Default User constructor
     */
    public User() {
    }

    /**
     * The getUserId method to return the userId
     * @return the unique user ID
     */
    public int getUserId() {

        return userId;
    }

    /**
     * The setUserId method to set the userId
     * @param userId the unique user ID
     */
    public void setUserId(int userId) {

        this.userId = userId;
    }

    /**
     * The getUserName method to return the userName
     * @return the name of the user
     */
    public String getUserName() {

        return userName;
    }

    /**
     * The setUserName method to set the userName
     * @param userName the name of the user
     */
    public void setUserName(String userName) {

        this.userName = userName;
    }

    /**
     * The getUserPassword method to return the userPassword
     * @return  the password of the user
     */
    public String getUserPassword() {

        return userPassword;
    }

    /**
     * The setUserPassword method to set the userPassword
     * @param userpassword the password of the user
     */
    public void setUserPassword(String userpassword) {

        this.userPassword = userpassword;
    }
}
