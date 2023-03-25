/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tmubank;

/**
 *
 * @author dhruv
 */
public class User {
    /* User variables */
    private String userUsername;
    private String userEmail;
    private String userID;
    private String userPassword;

    /**
     * Parameterized constructor which initialize the variable
     * @param userUsername
     * @param userEmail
     * @param userPassword
     */
    public User(String userUsername,String userEmail,String userPassword){
        this.userUsername = userUsername;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userID = "";
    }

    /**
     * return username using getUserUsername
     * @return
     */
    public String getUserUsername() {
        return userUsername;
    }

    /**
     * SetUsername function set the username
     * @param userUsername
     */
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    /**
     * return email address of the user
     * @return
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * set the email of the username
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * return the user ID of the user
     * @return
     */
    public String getUserID() {
        return userID;
    }

    /**
     * set the user ID
     * @param userID
     */
    public void setUserID(String userID) {

        this.userID = userID;
    }

    /**
     * get the password of the user
     * @return
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * set the password of the user
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
