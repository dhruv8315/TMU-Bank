/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tmubank;

/**
 *
 * @author dhruv
 */
public class Chequing extends Account{
    private double chequingBalance;
    private double chequingDespoit;
    private double chequingWithdraw;

    /**
     * parameterized constructor initialize the variable
     *
     * @param u
     * @param accountType
     */
    public Chequing(User u, String accountType) {
        super(u, "Chequing");
    }

    /**
     *get the chequing balance of chequing account
     * @return
     */
    public double getChequingBalance() {
        return chequingBalance;
    }

    /**
     *  add to the balance of chequing account
     * @param chequingBalance
     */
    public void setChequingBalance(double chequingBalance) {
        this.chequingBalance += chequingBalance;
    }

    /**
     *  get deposit of chequing account
     * @return
     */
    public double getChequingDespoit() {
        return chequingDespoit;
    }

    /**
     * set the deposit of Chequing deposit
     * and add to the balance
     * @param Despoit
     */
    public void setChequingDespoit(double Despoit) {
        this.chequingDespoit = Despoit;
        setChequingBalance(chequingDespoit);
    }

    /**
     * get the withdrawal amount
     * @return
     */
    public double getChequingWithdraw() {
        return chequingWithdraw;
    }

    /**
     * set the withdrawal amount
     * @param chequingWithdraw
     */
    public void setChequingWithdraw(double chequingWithdraw) {
        this.chequingWithdraw = chequingWithdraw;
    }
}
