// This class using the database: selecting entries in table and print in console.

package com.gmichaels.javaandmysql.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBWSelect {

    static DataBaseWorker dbWorker = new DataBaseWorker();
    static ResultSet resultSet;

    public static void startSelect () {

        try {

            dbWorker.createConnection();

            resultSet = dbWorker.getStatement().executeQuery("SELECT * FROM users");

            System.out.println("Showing all entries in database!");

            System.out.printf("%3s%10s%10s%20s%13s", "ID",
                                                     "Login",
                                                     "Password",
                                                     "EMail",
                                                     "Created" + "\n");

            while (resultSet.next()) {

                DataBaseWorker worker = new DataBaseWorker();
                worker.setId(resultSet.getInt("id"));
                worker.setLogin(resultSet.getString("login"));
                worker.setPassword(resultSet.getString("password"));
                worker.setEmail(resultSet.getString("email"));
                worker.setDate(resultSet.getString("created"));

                System.out.printf("%3d%10s%10s%20s%13s", worker.getId(),
                                                         worker.getLogin(),
                                                         worker.getPassword(),
                                                         worker.getEmail(),
                                                         worker.getDate() + "\n");

            }

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

}
