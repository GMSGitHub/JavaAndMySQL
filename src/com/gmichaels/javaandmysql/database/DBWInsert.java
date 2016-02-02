// This class using the database: adding entries to table.

package com.gmichaels.javaandmysql.database;

import java.sql.SQLException;

public class DBWInsert {

    static DataBaseWorker dbWorker = new DataBaseWorker();

    public static void startInsert () {

        try {

            dbWorker.createConnection();

            dbWorker.getStatement().execute("INSERT INTO users (login, password, email, created) " +
                                            "VALUES ('Admin', '12345', 'support@dbw.com', CURRENT_DATE)");

            System.out.println("Entry is added to the database!");

            dbWorker.closeConnection();

        } catch (SQLException sqle) {

            System.err.println("SQLException: " + sqle.getMessage());

        }

    }

}
