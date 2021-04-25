package com.example.lab2se1;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    Account account = new Account("bogge", "hej123", 99);
    String expectedUsername;
    String actualUsername;
    String actualPassword;
    String expectedPassword;
    float expectedBalance;
    float actualBalance;


    @Test
    public void Account() {
        Account account = new Account("rille", "ko12", 101);
        actualUsername = account.username;
        actualPassword = account.password;
        actualBalance = account.balance;
        expectedUsername = "rille";
        expectedPassword = "ko12";
        expectedBalance = 101;

        Assert.assertEquals(expectedUsername, actualUsername);
        Assert.assertEquals(expectedPassword, actualPassword);
        Assert.assertEquals(expectedBalance, actualBalance, 0.0);
    }

    @Test
    public void getUsername() {
        expectedUsername = "bogge";
        actualUsername = account.getUsername();
        Assert.assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void setUsername() {
        account.setUsername("nudd");
        expectedUsername = "nudd";
        actualUsername = account.username;
        Assert.assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void getPassword() {
        actualPassword = account.getPassword();
        expectedPassword = "hej123";
        Assert.assertEquals(expectedPassword, actualPassword);
    }

    @Test
    public void setPassword() {
        account.setPassword("123hej");
        expectedPassword = "123hej";
        actualPassword = account.password;
        Assert.assertEquals(expectedPassword, actualPassword);
    }

    @Test
    public void getBalance() {
        expectedBalance = 99;
        actualBalance = account.getBalance();
        Assert.assertEquals(expectedBalance, actualBalance, 0.0);
    }

    @Test
    public void setBalance() {
        account.setBalance(400);
        expectedBalance = 400;
        actualBalance = account.balance;
        Assert.assertEquals(expectedBalance, actualBalance, 0.0);
    }
}