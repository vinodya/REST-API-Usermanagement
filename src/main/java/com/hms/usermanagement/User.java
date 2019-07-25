package com.hms.usermanagement;

public class User  {

    private int userid;
    private String username;
    private String userpassword;

    public User(int userid, String username, String userpassword) {
        this.userid = userid;
        this.username = username;
        this.userpassword = userpassword;
    }

    public User() {
    }

    public int getUserId() {

        return userid;
    }

    public void setUserId(int userid) {

        this.userid = userid;
    }

    public String getUserName() {

        return username;
    }

    public void setUserName(String username) {

        this.username = username;
    }

    public String getUserPassword() {

        return userpassword;
    }

    public void setUserPassword(String userpassword) {

        this.userpassword = userpassword;
    }
}
