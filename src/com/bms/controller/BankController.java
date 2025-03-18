package com.bms.controller;

import com.bms.dao.CustomerDAO;
import com.bms.model.Customer;

public class BankController {
    private CustomerDAO customerDAO = new CustomerDAO();
    
    public void addCustomer(int customerId, String name, int accountNumber, double balance) {
        Customer customer = new Customer(customerId, name, accountNumber, balance);
        customerDAO.addCustomer(customer);
    }
    
    public void displayCustomers() {
        customerDAO.displayCustomers();
    }
    
    public void deposit(int accountNumber, double amount) {
        customerDAO.updateBalance(accountNumber, amount, true);
    }
    
    public void withdraw(int accountNumber, double amount) {
        customerDAO.updateBalance(accountNumber, amount, false);
    }
    
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }
}
