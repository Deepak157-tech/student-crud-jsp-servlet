package com.product;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventory_db",
                "root",
                "kern@123"   // 👈 CHANGE THIS
            );

        } catch (Exception e) {
            e.printStackTrace();   // VERY IMPORTANT
        }

        return con;
    }
}