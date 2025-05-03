// 1.Create a class to represent the ATM machine.
//  2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
//  checking the balance.
//  3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
//  checkBalance().
//  4. Create a class to represent the user's bank account, which stores the account balance.
//  5. Connect the ATM class with the user's bank account class to access and modify the account
//  balance.
//  6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
//  7. Display appropriate messages to the user based on their chosen options and the success or failure
//  of their transactions.

import java.util.InputMismatchException;
import java.util.Scanner;

class Bank{
    private double balance;
    public Bank(double initialBalance){
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
        } else {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Your current balance is Rs." + balance);
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew Rs." + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

}
class ATM{
    Scanner sc;
    ATM(Scanner sc){
        this.sc = sc;
    }
    public void show(Bank account){
        int choice = 0;
        do{
            displayMenu();
                System.out.println("Enter your choice : ");
            try{
            choice = sc.nextInt();
                switch(choice){
                    case 1 : withdraw(account);
                            break;
                    case 2 : deposit(account);
                            break;  
                    case 3 : checkBalance(account);
                            break;
                    case 4 : System.out.println("Thank you for using the ATM. Have a great day!");
                            break;
                    default: System.out.println("Invalid choice. Please select from 1 to 4.");
                }
            } 
            catch(InputMismatchException e){
                System.out.println("invalid input! Enter integers only");
                sc.nextLine(); //consumes the next line 
            }
        }while(choice!=4);
       
    }
    private void displayMenu() {
        System.out.println("\n====== Welcome to the ATM ======");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("================================");
    }
    private void withdraw(Bank account) {
        try {
            System.out.print("Enter amount to withdraw: Rs.");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
            sc.nextLine();
        }
    }
    private void deposit(Bank account) {
        try {
            System.out.print("Enter amount to deposit: Rs.");
            double amount = sc.nextDouble();
            account.deposit(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
            sc.nextLine();
        }
    }
    private void checkBalance(Bank account) {
        System.out.println("Your current balance is: Rs." + account.getBalance());
    }
    
}
public class _03_atmInterface{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double initialBalance = 0;

        System.out.print("Enter your initial account balance: Rs.");
        try {
            initialBalance = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid input. Starting with ₹0 balance.");
            sc.nextLine();
        }

        Bank userAccount = new Bank(initialBalance);
        ATM atmMachine = new ATM(sc);
        atmMachine.show(userAccount);
    }
}
