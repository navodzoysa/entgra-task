package com.entgra.entgratask.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/";
                String dbName = "device_schema";
                String driver = "com.mysql.cj.jdbc.Driver";
                String userName = "root";
                String password = "root";

                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(url + dbName, userName, password);

            }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                System.out.println("Database Connection Error : " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
