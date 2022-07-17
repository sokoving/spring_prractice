package com.spring.practice;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBConnectTest {


    String uid = "hr";
    String upw = "hr";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String driver = "oracle.jdbc.driver.OracleDriver";

    @Test
    public void connectTest() {

        try {
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "SELECT first_name FROM employees";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("first_name"));
            }

        } catch (Exception e) {
            System.out.println("예외 발생");
            e.printStackTrace();

        }
    }

}
