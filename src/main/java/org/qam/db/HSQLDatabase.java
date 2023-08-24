package org.qam.db;

import org.qam.exception.DBException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLDatabase {
    private static final String EMBEDDED_DB_URL = "jdbc:hsqldb:file:/path/to/your/data/directory/mydb;shutdown=true";
    private Connection connection;

    public HSQLDatabase() {
        try {
            connection = DriverManager.getConnection(EMBEDDED_DB_URL, "SA", "");
            initDatabase();
        } catch (SQLException e) {
            throw new DBException("Error initializing database", e);
        }
    }

    private void initDatabase() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS sample_table (id INT PRIMARY KEY, name VARCHAR(255))");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
