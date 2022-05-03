package com.example.companias.foundation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConfig {
    final String DATABASE_PATH = "jdbc:sqlite:companies_1000.db";
    private Connection connection;

    public DbConfig() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DATABASE_PATH);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() { return connection; }
}
