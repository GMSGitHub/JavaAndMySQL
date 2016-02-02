// This class using the database: editing entries in table.

package com.gmichaels.javaandmysql.database;

import java.sql.SQLException;

public class DBWUpdate {

    static DataBaseWorker dbWorker = new DataBaseWorker();

    public static void startUpdate () {

        try {

            dbWorker.createConnection();

            System.out.println("Entries successfully updated!");

            dbWorker.getStatement().executeUpdate("UPDATE users SET login = 'DBWTest' WHERE id = 1;");

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

}
