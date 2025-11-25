// Lab 7 için.

import java.util.Scanner;

public class BankAccount {

    private String accountID;
    private double balance;

    public BankAccount(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String newID) {
        this.accountID = newID;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance = " + balance);
        } else {
            System.out.println("Amount must be greater than zero!");
        }
    }

    public void withdraw(double amount) {
        Scanner input = new Scanner(System.in);

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful! New balance = " + balance);
        } else {
            System.out.println("Insufficient balance!");
            System.out.print("Do you want to go into borrowing? (yes/no): ");

            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                balance -= amount;
                System.out.println("Borrowing accepted. New balance = " + balance);
            } else {
                System.out.println("Transaction cancelled!");
            }
        }
    }

    public void accountDetails() {
        System.out.println("------ ACCOUNT DETAILS ------");
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: " + balance);
    }
}
