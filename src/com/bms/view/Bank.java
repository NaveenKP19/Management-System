package com.bms.view;

import java.util.Scanner;

import com.bms.controller.BankController;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankController controller = new BankController();
        
        System.out.println("Bank Management System");
        while (true) {
            System.out.println("1. Add Customer\n2. Display Customers\n3. Deposit\n4. Withdraw\n5. Delete Customer\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter Account Number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    controller.addCustomer(customerId, name, accountNumber, initialBalance);
                    break;
                case 2:
                    controller.displayCustomers();
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int accNumD = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double amountD = scanner.nextDouble();
                    controller.deposit(accNumD, amountD);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    int accNumW = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double amountW = scanner.nextDouble();
                    controller.withdraw(accNumW, amountW);
                    break;
                case 5:
                    System.out.print("Enter Customer ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    controller.deleteCustomer(deleteId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
