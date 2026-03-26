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
}
