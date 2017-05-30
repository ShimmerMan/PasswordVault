package com.shimmerman.passwordvault.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is for the Security Questions that are associated with the Master Account.
 * A Security Question contains the question itself and its corresponding answer.
 * @author Jeremy Larsen
 */
public class SecurityQuestion implements DatabaseObjectAddable {

    /**
     * The security question.
     */
    private String securityQuestion;

    /**
     * The answer to the question.
     */
    private String securityAnswer;

    /**
     * The master account this question belongs to.
     */
    private String masterAccountName;

    /**
     * Constructor for creating a new Security Question.
     * @param securityQuestion The Security Question.
     * @param securityAnswer The answer to the Security Question.
     */
    public SecurityQuestion(String securityQuestion, String securityAnswer) {
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    public SecurityQuestion(String securityQuestion, String securityAnswer, String masterAccountName) {
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.masterAccountName = masterAccountName;
    }

    /**
     * Get the propertiues of the security question as a database object.
     * @return The Security Question's properties
     */
    public Map<String, Object> getDatabaseObjectProperties() {

        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("securityQuestion", getSecurityQuestion());
        properties.put("securityAnswer", getSecurityAnswer());
        properties.put("masterAccountName", getMasterAccountName());

        return properties;
    }

    /**
     * Get the Security Question.
     * @return The Security Question.
     */
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    /**
     * Set the Security Question.
     * @param securityQuestion The Security Question to set.
     */
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    /**
     * Get the answer to the Security Question.
     * @return The answer to the Security Question.
     */
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    /**
     * Set the answer to the Security Question.
     * @param securityAnswer The answer to set for the Security Question.
     */
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    /**
     * Get the name of the master account the question belongs to.
     * @return The username of the master account.
     */
    public String getMasterAccountName() {
        return masterAccountName;
    }
}
