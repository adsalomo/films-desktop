package com.cuevana.films.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase conexión DB
 * @author adrian
 */
public class ConnectionManager {
    
    public static final String URL = "jdbc:postgresql://localhost:5432/movies";
    public static final String USER = "postgres";
    public static final String PASSWORD = "123456";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
 
}
