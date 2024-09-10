package org.example;

import java.sql.*;

public class UserDao {

    public void create(User user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            String sql = "insert into users values(?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private Connection getConnection() {
        String url = "jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
        String id = "sa";
        String pw = "";

        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            return null;
        }
    }

    public User findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String sql = "select * from users where userId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();
            User user = null;

            if (rs.next()) {

                user = new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }

            return user;
        } finally {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(con != null) con.close();
        }
    }
}
