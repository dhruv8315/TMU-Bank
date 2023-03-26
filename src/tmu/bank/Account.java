/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tmubank;

import com.mycompany.tmubank.BankDatabase.DatabaseCon;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
    /*
    * return the User class object
    */
    public User getU() {
        return U;
    }

    /*
    * set the User class object
    * @params u 
    */
    public void setU(User u) {
        this.U = u;
    }

    /*
    * return balance of the balance
    */
    public double getBalance() {
        return balance;
    }
    
    /*
    * set the balance 
    */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
    * return transactionHistory arraylist
    * that has transaction details.
    */
    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    /*
    * set the transactionHistory
    */
    public void setTransactionHistory(ArrayList<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    /*
    * deposit the amount and return true if it is true
    * as false
    */
    public boolean deposit(double amount){
        DatabaseCon dbcon = new DatabaseCon();
        this.balance += amount;
        Transaction transaction = new Transaction(amount,"Deposit");
        this.transactionHistory.add(transaction);
        
        return dbcon.depositUser(this,getU());
    }

    /*
    * withdraw the the given amount
    */
    public void withdraw(double amount) {
        if(amount < balance){
            balance -= amount;
            Transaction transaction = new Transaction(amount, "Withdrawal");
            transactionHistory.add(transaction);
        }
        else{
            System.out.println("Withdraw failed due insufficient balance");
            JOptionPane.showMessageDialog(null, "Withdraw failed due insufficient balance", "Title", 1);
        }
            
    }

    /*
    * transfer the amount between the users
    */
    public void transfer(double amount, Account recipient) {
        if(amount < balance){
            balance -= amount;
            recipient.setBalance(recipient.getBalance() + amount);
            Transaction transaction = new Transaction(amount, "Transfer to " + recipient.getU().getUserUsername());
            transactionHistory.add(transaction);
            recipient.getTransactionHistory().add(transaction);
        }
        else{
            System.out.println("Tranaction failed due insufficient balance");
            JOptionPane.showMessageDialog(null, "Tranaction failed due insufficient balance", "Error", 1);
        }
        
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
