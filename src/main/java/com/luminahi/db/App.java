package com.luminahi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.luminahi.db.lib.ConfigLoader;

public class App {
    
    public static void main(String[] args) {
        ConfigLoader configLoader = new ConfigLoader("config.properties");

        String url = configLoader.getProperties("db.url");
        String user = configLoader.getProperties("db.username");
        String password = configLoader.getProperties("db.password");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected!");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM CHARACTERS");
            while (result.next()) {
                System.out.print("Column 2 returned ");
                System.out.println(result.getString(2));
            }

            result.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
