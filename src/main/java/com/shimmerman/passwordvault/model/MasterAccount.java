package com.shimmerman.passwordvault.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a class for the Master Account, extending Account, that also contains a list of Security
 * Questions with the functionality to create and delete Security Questions.
 * @author Jeremy Larsen
 */
public class MasterAccount extends Account implements DatabaseObjectAddable {

    /**
     * List of Security Questions.
     */
    private List<SecurityQuestion> securityQuestions;

    /**
     * Constructor for a Master Account.
     * @param username The username of the Master Account.
     * @param password The encrypted password for the Master Account.
     * @param securityQuestions The list of Security Questions for the Master Account.
     */
    public MasterAccount(String username, String password, List<SecurityQuestion> securityQuestions) {
        super(username, password);
        this.securityQuestions = securityQuestions;
    }

    /**
     * Gets the list of Security Questions.
     * @return Security Question List.
     */
    public List<SecurityQuestion> getSecurityQuestions() {
        return securityQuestions;
    }

    /**
     * Sets the list of Security Questions with a new list.
     * @param securityQuestions The new list of Security Questions to set.
     */
    public void setSecurityQuestions(List<SecurityQuestion> securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    /**
     * Creates a new security question. Needs finishing.
     * @param securityQuestion The Security Question object to create.
     * @return boolean for successful creation.
     */
    public boolean createSecurityQuestion(SecurityQuestion securityQuestion) {

        return true;
    }

    /**
     * Deletes a security question. Needs finishing.
     * @param securityQuestion The Security Question object to delete.
     * @return boolean for successful deletion.
     */
    public boolean deleteSecurityQuestion(SecurityQuestion securityQuestion) {

        return true;
    }

    public Map<String, Object> getDatabaseObjectProperties() {

        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("username", getUsername());
        properties.put("password", getPassword());

        return properties;
    }
}
