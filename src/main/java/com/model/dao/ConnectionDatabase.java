package com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu_1","root","");
        if (con != null) {
            System.out.println("Success database connect");
            return con;
        }
        return null;
    }
}
