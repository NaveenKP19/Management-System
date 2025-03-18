package com.bms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.model.Customer;

public class CustomerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bank_db";
    private static final String USER = "root";
    private static final String PASSWORD = "naveenpcsql";

    public void addCustomer(Customer customer) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO customers (customer_id, name, account_number, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, customer.getCustomerId());
            pstmt.setString(2, customer.getName());
            pstmt.setInt(3, customer.getAccountNumber());
            pstmt.setDouble(4, customer.getBalance());
            pstmt.executeUpdate();
            System.out.println("Customer added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayCustomers() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("customer_id") + ", Name: " + rs.getString("name") + ", Account: " + rs.getInt("account_number") + ", Balance: " + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBalance(int accountNumber, double amount, boolean isDeposit) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE customers SET balance = balance " + (isDeposit ? "+" : "-") + " ? WHERE account_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accountNumber);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println((isDeposit ? "Deposited " : "Withdrawn ") + amount + " successfully!");
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "DELETE FROM customers WHERE customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, customerId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Customer deleted successfully!");
            } else {
                System.out.println("Customer not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

