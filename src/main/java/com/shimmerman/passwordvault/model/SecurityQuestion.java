package com.shimmerman.passwordvault.model;

/**
 * This class is for the Security Questions that are associated with the Master Account.
 * A Security Question contains the question itself and its corresponding answer.
 * @author Jeremy Larsen
 */
public class SecurityQuestion {

    /**
     * The security question.
     */
    private String securityQuestion;

    /**
     * The answer to the question.
     */
    private String securityAnswer;

    /**
     * Constructor for creating a new Security Question.
     * @param securityQuestion The Security Question.
     * @param securityAnswer The answer to the Security Question.
     */
    public SecurityQuestion(String securityQuestion, String securityAnswer) {
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
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
}
