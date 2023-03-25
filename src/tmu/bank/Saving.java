/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tmubank;

/**
 *
 * @author dhruv
 */
public class Saving extends Account{
    private double saveBalance;
    private double savingDeposit;
    private float interestRate;
    /**
     * parameterized constructor initialize the variable
     *
     * @param u
     * @param accountType
     */
    public Saving(User u, String accountType) {
        super(u, "Saving");
    }

    /**
     * return the savings balance
     * @return
     */
    public double getSavingBalance() {
        return saveBalance;
    }

    /**
     * set the balance
     * @param saveBalance
     */
    public void setSaveBalance(double saveBalance) {
        this.saveBalance += saveBalance;
    }

    /**
     * return the deposit amount
     * @return
     */
    public double getSavingDeposit() {
        return savingDeposit;
    }

    /**
     * update the balance of saving account
     */
    public void setSavingDeposit(double Deposit) {
        this.savingDeposit = Deposit;
        setSaveBalance(savingDeposit);
    }

    /**
     * return the interest rate
     * @return
     */
    public float getInterestRate() {
        return interestRate;
    }

    /**
     * set the interest rate
     * @param interestRate
     */
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
}
