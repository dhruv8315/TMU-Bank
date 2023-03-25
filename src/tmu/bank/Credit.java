/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tmubank;

/**
 *
 * @author dhruv
 */
public class Credit extends Account{
    private double creditLimit;
    private double creditBalance;

    /**
     * parameterized constructor initialize the variable
     *
     * @param u
     * @param accountType
     */
    public Credit(User u, String accountType) {
        super("Credit");
    }

    public void PayBills(){

    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditLimit -= creditBalance;
        this.creditBalance = this.creditLimit;
    }
}
