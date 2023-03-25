/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tmubank;

import com.mycompany.tmubank.BankDatabase.DatabaseCon;
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
     * @param accountType
     * *@param balance
     */
    public Account(String accountType) {
        this.accountType = accountType;
        this.balance = 0;
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

    public boolean deposit(double amount){
        DatabaseCon dbcon = new DatabaseCon();
        this.balance += amount;
        Transaction transaction = new Transaction(amount,"Deposit");
        this.transactionHistory.add(transaction);
        
        return dbcon.depositUser(this,getU());
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
