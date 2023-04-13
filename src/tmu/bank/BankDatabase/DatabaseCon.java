package com.mycompany.tmubank.BankDatabase;

import com.mycompany.tmubank.Account;
import java.sql.*;
import com.mycompany.tmubank.User;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon {

    public static void main(String[] args) throws Exception {
        getConnection();
    }
    static Connection con;

    /*
    *  DatabaseCon() constructor calls getConnection function 
    * that create connection with the database
    */
    public DatabaseCon() {
        try {
            getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DatabaseCon(Connection c) {
        con = c;
    }
    
    /*
    * getConnection 
    * Create connection with the database
    */
    public static Connection getConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/banking";
            String username = "root";
            String password = "root";

            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("connected to database!");
            return con;
        } catch (Exception e) {
            String message = e.getMessage().split("\n", 2)[0].toLowerCase().replaceAll(" ", "");
        }
        return null;
    }

    public boolean loginUser(User u) {
        String dbUsername = null;
        String dbPassword = null;
        String uname = u.getUserUsername();
        String pass = u.getUserPassword();
        String select = "SELECT username, password FROM users WHERE username = '" + uname + "' and password = '" + pass + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            if(rs.next()) {
                
                dbUsername = rs.getString("username");
                dbPassword = rs.getString("password");
                if (uname.equals(dbUsername) && (pass).equals(dbPassword)) {
                    System.out.println("User found");
                    return true;
                }
                else{
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("No user found");
            e.printStackTrace();
        }
        return false;
    }

    /*
    * insert the value ofthe user into User database
    * if it is successful then return true
    * else return false
     */
    public boolean registerUser(User u) {
        /*
        uname
        email
        password
         */

        String uname = u.getUserUsername();
        String pass = u.getUserPassword();
        String email = u.getUserEmail();
        String insert = "INSERT INTO users(username, password, email) VALUES ('" + uname + "','" + pass + "','" + email + "');";
        try {
            PreparedStatement st = con.prepareStatement(insert);

            int changedRow = st.executeUpdate(insert);
            if (changedRow > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    public int returnUserID(User u){
        int idNumber = 0;
        String query = "SELECT id FROM users WHERE username = '"+u.getUserUsername()+"'";
        
        try{
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                idNumber = rs.getInt("id");
                System.out.println(idNumber);
                return idNumber;
            }
            else{
                System.out.println("Something went wrong!");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
       
        return 0;
    }
    /*
    * deposit the user amount into database
    takes the object of account class as input
    */
    public boolean depositUser(Account a, User u){
        
        double amount = a.getBalance();
        System.out.println(amount);
        String update ="UPDATE bank_accounts SET balance = balance + "+ amount +" WHERE user_id = 11 ;";
        
        try {
            PreparedStatement st = con.prepareStatement(update);

            if (!st.execute(update)) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     *
     * @param a
     * @param u
     * @return true if the amount is deducted successfully
     * else false is returned
     */
    public boolean withdrawUser(Account a, User u){
        double amount = a.getBalance();
        System.out.println(amount);
        String update ="UPDATE bank_accounts SET balance = balance - "+ amount +" WHERE user_id = 11 ;";
        try {
            PreparedStatement st = con.prepareStatement(update);
            
            if (!st.execute(update)) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * fetch the balance from the database if the process is successful
     * then return true
     * else return false
     * @param a
     * @param u
     * @return
     */
    public double checkBalanceUser(Account a, User u){
        String selectQuery = "select balance from bank_accounts where user_id = 11;";

        try{
            PreparedStatement st = con.prepareStatement(selectQuery);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                double amount = rs.getDouble("balance");
                return amount;
            }

        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
}
