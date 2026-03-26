package org.example;

import javax.swing.*;

public class user {

    private int userId;
    private String usernName;
    private String Password;
    private String gender;

    public user () {

        this.userId = 0;
        this.usernName = "" ;
        this.Password = "";
        this.gender = "";
    }

    public user(int userId, String usernName, String Password, String gender) {

        this.userId = userId;
        this.usernName = usernName;
        this.Password = Password;
        this.gender = gender;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsernName() {
        return usernName;
    }
    public void setUsernName(String usernName) {
        this.usernName = usernName;
    }

    public String getPassword () {
        return Password;
    }
    public void setPassword() {
        this.Password = Password;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
}