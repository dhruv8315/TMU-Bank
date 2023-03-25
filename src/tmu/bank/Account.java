/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tmubank;

import java.util.ArrayList;
/**
 *
 * @author dhruv
 */
public class Account {
    private User U;
    private double balance;
    private String accountType;
    private ArrayList<Transaction> transactionHistory;
    /**
     * parameterized constructor initialize the variable
     * @param u
     * @param accountType
     */
    public Account(User u, String accountType) {
        U = u;
        this.accountType = accountType;
        this.transactionHistory = new ArrayList<>();
    }

    public User getU() {
        return U;
    }

    public void setU(User u) {
        this.U = u;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void deposit(double amount){
        balance += amount;
        Transaction transaction = new Transaction(amount,"Deposit");
        this.transactionHistory.add(transaction);
    }

    public void withdraw(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(amount, "Withdrawal");
        transactionHistory.add(transaction);
    }

    public void transfer(double amount, Account recipient) {
        balance -= amount;
        recipient.setBalance(recipient.getBalance() + amount);
        Transaction transaction = new Transaction(amount, "Transfer to " + recipient.getU().getUserUsername());
        transactionHistory.add(transaction);
        recipient.getTransactionHistory().add(transaction);
    }
    /**
     * get the account type of user
     * @return
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * set the account type of the user
     * @param accountType
     */
    public void setAccountType(String accountType) {

        this.accountType = accountType;
    }
}
