// This class using the database: PreparedStatement.
// Insert, Select, Update, Delete.

package com.gmichaels.javaandmysql.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class DBWPreparedStatement {

    static DataBaseWorker dbWorker = new DataBaseWorker();
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;

    private static final String INSERT = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT = "SELECT * FROM users";
    private static final String UPDATE = "UPDATE users SET login = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM users WHERE id = ?";

    public static void startPrepStatInsert () {

        try {

            dbWorker.createConnection();

            preparedStatement = dbWorker.getConnection().prepareStatement(INSERT);

            preparedStatement.setInt(1, 50);
            preparedStatement.setString(2, "DBWTest");
            preparedStatement.setString(3, "12345");
            preparedStatement.setString(4, "dbwtest@dbw.com");
            preparedStatement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));

            preparedStatement.execute();

            System.out.println("PreparedStatement finished his work!");

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

    public static void startPrepStatSelect () {

        try {

            dbWorker.createConnection();

            preparedStatement = dbWorker.getConnection().prepareStatement(SELECT);

            resultSet = preparedStatement.executeQuery(SELECT);

            System.out.println("Showing all entries in database!");

            System.out.printf("%3s%10s%10s%20s%13s", "ID",
                                                     "Login",
                                                     "Password",
                                                     "EMail",
                                                     "Created" + "\n");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String date = resultSet.getString("created");

                System.out.printf("%3d%10s%10s%20s%13s", id,
                                                         login,
                                                         password,
                                                         email,
                                                         date + "\n");

            }

            preparedStatement.execute();

            System.out.println("PreparedStatement finished his work!");

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

    public static void startPrepStatUpdate () {

        try {

            dbWorker.createConnection();

            preparedStatement = dbWorker.getConnection().prepareStatement(UPDATE);

            preparedStatement.setString(1, "DBWAdmin");
            preparedStatement.setInt(2, 2);

            preparedStatement.executeUpdate();

            System.out.println("PreparedStatement finished his work!");

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

    public static void startPrepStatDelete () {

        try {

            dbWorker.createConnection();

            preparedStatement = dbWorker.getConnection().prepareStatement(DELETE);

            preparedStatement.setInt(1, 50);
            preparedStatement.executeUpdate();

            preparedStatement.execute();

            System.out.println("PreparedStatement finished his work!");

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

}
