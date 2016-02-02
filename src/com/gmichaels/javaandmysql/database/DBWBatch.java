// This class using the database: creating batch and execute her.

package com.gmichaels.javaandmysql.database;

import java.sql.SQLException;

public class DBWBatch {

    static DataBaseWorker dbWorker = new DataBaseWorker();

    public static void startBatch () {

        try {

            dbWorker.createConnection();

            dbWorker.getStatement().addBatch("INSERT INTO users (login, password, email, created)" +
                                             "VALUES ('Jack', '111', 'jack@dbw.com', CURRENT_DATE)");

            dbWorker.getStatement().addBatch("INSERT INTO users (login, password, email, created)" +
                                             "VALUES ('Alex', '222', 'alex@dbw.com', CURRENT_DATE)");

            dbWorker.getStatement().addBatch("INSERT INTO users (login, password, email, created)" +
                                             "VALUES ('Tom', '333', 'tom@dbw.com', CURRENT_DATE)");

            dbWorker.getStatement().executeBatch();
            dbWorker.getStatement().clearBatch();

            System.out.println("Query executed successfully!");

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

}
