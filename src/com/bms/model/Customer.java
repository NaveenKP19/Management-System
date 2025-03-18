package com.bms.model;

public class Customer {
    private int customerId;
    private String name;
    private int accountNumber;
    private double balance;

    public Customer(int customerId, String name, int accountNumber, double balance) {
        this.customerId = customerId;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
}
