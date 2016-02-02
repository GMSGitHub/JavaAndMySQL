package com.gmichaels.javaandmysql;

import com.gmichaels.javaandmysql.database.*;

public class StartClass {

    public static void main(String[] args) {

        System.out.println("Welcome to DataBase Worker!");

        // Insert.
        DBWInsert.startInsert();

        // Update.
        DBWUpdate.startUpdate();

        // Select.
        DBWSelect.startSelect();

        // Batch.
        DBWBatch.startBatch();

        // PreparedStatement.
        DBWPreparedStatement.startPrepStatInsert();
        DBWPreparedStatement.startPrepStatSelect();
        DBWPreparedStatement.startPrepStatUpdate();
        DBWPreparedStatement.startPrepStatDelete();

    }

}
