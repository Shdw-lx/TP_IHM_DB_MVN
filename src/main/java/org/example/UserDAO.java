package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public user getUser(String usernName, String Password) {

        String sql = "SELECT * FROM user WHERE usernName = ? AND Password = ?";

        try (Connection conn = db_conf.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usernName);
            stmt.setString(2, Password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new user(
                        rs.getInt("userId"),
                        rs.getString("usernName"),
                        rs.getString("Password"),
                        rs.getString("gender")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean createUser(user user) {

        String sql = "INSERT INTO user (userId, usernName, Password, gender) VALUES (?,?,?,?)";

        try (Connection conn = db_conf.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getUsernName());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getGender());

            int rowsInserted = stmt.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }
    }
}
