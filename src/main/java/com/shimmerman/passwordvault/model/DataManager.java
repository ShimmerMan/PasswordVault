package com.shimmerman.passwordvault.model;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Manages the database in terms of connections and saveing/getting data.
 * @author Carl
 */
public class DataManager {

    final static Logger logger = Logger.getLogger(DataManager.class);


    private static String dbType = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String dbURL = "jdbc:derby:PasswordVault.db;user=admin;password=admin";
    private static String tableName = "restaurants";


    private static Connection conn = null;
    private static Statement stmt = null;


    private static boolean createConnection() throws Exception {
        logger.trace("Entering - createConnection");

        boolean isConnected= false;

        // Check if database exists and is not already open
        if (conn != null && !conn.isClosed()) {
            logger.info("Connection already established");
            isConnected = true;

        } else {
            logger.debug("Creating connection of type " + dbType);
            Class.forName(dbType).newInstance();

            // Get a connection
            conn = DriverManager.getConnection(dbURL + ";create=true");

            // Check if it successfully got a connection
            if (conn == null || conn.isClosed()) {
                logger.error("Could not connect to database");
            } else {
                logger.info("Successfully connected to database");
                isConnected = true;
            }
        }

        logger.trace("Leaving - createConnection");
        return isConnected;
    }

    private static boolean shutdown() throws Exception {
        logger.trace("Entering - shutdown");

        boolean isShutdown = false;

        // Check if the statement has closed, if not close it
        if (stmt != null) {
            logger.trace("Closing statement");
            stmt.close();
            stmt = null;
        }

        // Check if the connection is closed, if not close it
        if (conn != null) {
            logger.trace("Closing connection");
            //DriverManager.getConnection(dbURL + ";shutdown=true");

            if (!conn.isClosed())
                conn.close();

            conn = null;
        }

        // Check that is was closed successfully
        if (stmt != null && conn != null) {
            logger.error("Could not shutdown the database");
        } else {
            logger.info("Successfully shutdown the database");
            isShutdown = true;
        }

        logger.trace("Leaving - shutdown");
        return isShutdown;
    }


    public Account getAccount(String username) {
        return null  ;
    }

    public List<Account> getAccount(Class type) {
        return null  ;
    }

    public List<Object> getAccounts(Class type, String username) {
        return null  ;
    }

    public boolean add(Account account) {
        return false;
    }


    public boolean save(Account account) {
        return false;
    }

    public boolean commit() {
        return false;
    }
}
