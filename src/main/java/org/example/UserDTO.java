package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDTO {

    private int userId;
    private String usernName;
    private String Password;
    private String gender;

    public UserDTO () {

        this.userId = 0;
        this.usernName = "" ;
        this.Password = "";
        this.gender = "";
    }

    public UserDTO(int userId, String usernName, String Password, String gender) {

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
