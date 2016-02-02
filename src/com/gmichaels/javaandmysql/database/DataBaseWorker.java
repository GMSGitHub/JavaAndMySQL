// This is class create connection to database.

package com.gmichaels.javaandmysql.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseWorker {

    private static Driver driver;
    private static Connection connection;
    private static Statement statement;

    private static final String URL = "jdbc:mysql://localhost:3306/TestDataBase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2392";

    private static int id;
    private static String login;
    private static String password;
    private static String email;
    private static String date;

    public DataBaseWorker() { }

    public static void createConnection() {

        try {

            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            if (!connection.isClosed()) {

                System.out.println("Connecting to a database created successfully!");

            }

            if (connection.isClosed()) {

                System.out.println("Connecting to a database is closed!");

            }

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

    public static void closeConnection() {

        try {

            connection.close();

            if (connection.isClosed()) {

                System.out.println("Connecting to a database is closed!");

            }

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

    public static void setId(int id) {

        DataBaseWorker.id = id;

    }

    public static void setLogin(String login) {

        DataBaseWorker.login = login;

    }

    public static void setPassword(String password) {

        DataBaseWorker.password = password;

    }

    public static void setEmail(String email) {

        DataBaseWorker.email = email;

    }

    public static void setDate(String date) {

        DataBaseWorker.date = date;

    }

    public static Connection getConnection() {

        return connection;

    }

    public static Statement getStatement() {

        return statement;

    }

    public static int getId() {

        return id;

    }

    public static String getLogin() {

        return login;

    }

    public static String getPassword() {

        return password;

    }

    public static String getEmail() {

        return email;

    }

    public static String getDate() {

        return date;

    }

}
