package com.shimmerman.passwordvault.model;

/**
 * The user account class. This will be used to store information about an account.
 * @author Carl Hansen
 */
public class UserAccount extends Account{

    /**
     * The name of the account.
     */
    private String name;

    /**
     * The additional details of the account.
     */
    private String details;

    /**
     * Creates an account with a username, encrypted password and name.
     * @param username The username of the account.
     * @param password The encrypted password for the account.
     * @param name The name of the account.
     */
    public UserAccount(String username, String password, String name) {
        super(username, password);
        this.name = name;
    }

    /**
     * Creates an account with a username and encrypted password.
     * @param username The username of the account.
     * @param password The encrypted password for the account.
     * @param name The name of the account.
     * @param details The details of the account.
     */
    public UserAccount(String username, String password, String name, String details) {
        super(username, password);
        this.name = name;
        this.details = details;
    }

    /**
     * Get the name of the account.
     * @return The name of the account.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the account.
     * @param name The name of the account.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the details of the account.
     * @return The details.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set the details of the account.
     * @param details The details.
     */
    public void setDetails(String details) {
        this.details = details;
    }

}
