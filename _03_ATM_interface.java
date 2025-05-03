import java.util.Scanner;
class BankAccount {
    private double balance;

    BankAccount(double initialBalance) {
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
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        withdraw();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Have a great day!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select from 1 to 4.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); 
                choice = 0; 
            }

        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println("\n====== Welcome to the ATM ======");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("================================");
    }

    private void withdraw() {
        try {
            System.out.print("Enter amount to withdraw: ₹");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
            sc.nextLine();
        }
    }

    private void deposit() {
        try {
            System.out.print("Enter amount to deposit: ₹");
            double amount = sc.nextDouble();
            account.deposit(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
            sc.nextLine();
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }
}

// Main class to run the program
public class _03_ATM_interface{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double initialBalance = 0;

        System.out.print("Enter your initial account balance: ₹");
        try {
            initialBalance = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid input. Starting with ₹0 balance.");
            sc.nextLine();
        }

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();

        sc.close();
    }
}
