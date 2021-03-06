package com.shimmerman.passwordvault.model;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * Manages the database in terms of connections and saveing/getting data.
 * @author Carl
 * @author Jeremy
 */
public class DataManager {

    private static final Logger logger = Logger.getLogger(DataManager.class);

    private static String dbType = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String dbURL = "jdbc:derby:PasswordVault.db;user=admin;password=admin";

    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Checks the embedded databse and makes a connection.
     */
    public static boolean createConnection() throws Exception {
        logger.trace("Entering - createConnection");

        boolean isConnected = false;

        // Check if database exists and is not already open
        if (conn != null && !conn.isClosed()) {
            logger.info("Connection already established");
            isConnected = true;

        } else {
            logger.debug("Creating connection of type " + dbType);
            Class.forName(dbType).newInstance();

            // Get a connection
            conn = DriverManager.getConnection(dbURL + ";create=true");

            // Initialise Database Tables
            initialiseTables();

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

    /**
     * Shuts down statements and connections currently open to the database.
     */
    public static boolean shutdown() throws Exception {
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

    /**
     * Adds the object using the DatabseObjectAddable interface and determines the object to be added.
     * The object is a map.
     * @param object The object (a map) to be added.
     */
    public static boolean add(DatabaseObjectAddable object) throws Exception {
        logger.trace("Entering - add");

        boolean isAdded = false;

        if (conn != null) {

            Map<String, Object> properties = object.getDatabaseObjectProperties();

            // Is the object to be added a master account?
            if (object instanceof MasterAccount) {
                String username = properties.get("username").toString();
                String password = properties.get("password").toString();

                stmt = conn.createStatement();
                stmt.execute("insert into master_account values ('" + username + "','" + password + "')");
                stmt.close();

                //properties.get("username");

                isAdded = true;
                logger.trace("Master Account '" + username + "' added");
            }

            // Is the object to be added a security question?
            if (object instanceof SecurityQuestion) {
                String securityQuestion = properties.get("securityQuestion").toString();
                String securityAnswer = properties.get("securityAnswer").toString();
                String masterAccountName = properties.get("masterAccountName").toString();

                stmt = conn.createStatement();
                stmt.execute("insert into security_question values ('" + securityQuestion + "','" + securityAnswer + "','" + masterAccountName + "')");
                stmt.close();

                isAdded = true;
                logger.trace("Security Question '" + securityQuestion + "' added to Master Account '" + masterAccountName + "'");
            }
        }

        logger.trace("Leaving - add");
        return isAdded;
    }

    public boolean save(Account account) {
        logger.trace("Entering - save");



        logger.trace("Leaving - save");
        return false;
    }

    public boolean commit() {
        return false;
    }

    /**
     * Initialises all the tables if they don't already exist in the database.
     */
    private static boolean initialiseTables() throws SQLException {

        boolean isInitialised = false;

        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet tables = metaData.getTables(null, null, "MASTER_ACCOUNT", null);

        // Check for 'master_account' table
        if (!tables.next()) {
            stmt = conn.createStatement();
            stmt.execute("create table master_account (username varchar(20), password varchar(20), primary key (username))");
            stmt.close();
            logger.trace("Initialising 'master_account' table");
        } else {
            logger.trace("Already initialised 'master_account' table");
        }
        tables.close();

        // Check for 'security_question' table
        tables = metaData.getTables(null, null, "SECURITY_QUESTION", null);
        if (!tables.next()) {
            stmt = conn.createStatement();
            stmt.execute("create table security_question (securityquestion varchar(60), securityanswer varchar(20), username varchar(20) references master_account(username))");
            stmt.close();
            logger.trace("Initialising 'security_question' table");
        } else {
            logger.trace("Already initialised 'security_question' table");
        }
        tables.close();

        return isInitialised;
    }

    /**
     * Prints out to system the Master Account table.
     */
    public static void printMasterAccountTable() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from master_account");
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                String username = results.getString(1);
                String password = results.getString(2);
                System.out.println("\t\t" + username + "\t\t" + password);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    /**
     * Prints out to system the Master Account table.
     */
    public static void printSecurityQuestionTable() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from security_question");
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                String securityquestion = results.getString(1);
                String securityanswer = results.getString(2);
                String masteraccountname = results.getString(3);
                System.out.println("\t\t" + securityquestion + "\t\t" + securityanswer + "\t\t" + masteraccountname);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }
}
