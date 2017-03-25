package com.shimmerman.passwordvault.model;

/**
 * This is the base abstract class for all accounts.
 * @author Carl Hansen
 */
public abstract class Account {

    /**
     * The username of the account.
     */
    private String username;

    /**
     * The encrypted password for the account.
     */
    private String password;
    
    /**
     * Creates an account with no username or password.
     */
    public Account() {
    }

    /**
     * Creates an account with a username but no password.
     * @param username the username of the account.
     */
    public Account(String username) {
        this.username = username;
    }

    /**
     * Creates an account with a username and encrypted password.
     * @param username the username of the account.
     * @param password the encrypted password for the account.
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of the account.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of the account.
     * @param username the username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the encrypted password of the account.
     * @return the encrypted password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the encrypted password for the account.
     * @param password the encrypted password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
