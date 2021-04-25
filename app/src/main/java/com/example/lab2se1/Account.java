package com.example.lab2se1;

public class Account {

    String username;
    String password;
    float balance;

    public Account(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Account(){
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = 0;
    }
}
