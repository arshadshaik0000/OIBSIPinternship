import java.util.Scanner;

class Account {
    private String userId;
    private String userPin;
    private double balance;

    public Account(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
    }

    public boolean authenticate(String userId, String userPin) {
        return this.userId.equals(userId) && this.userPin.equals(userPin);
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }

    }

    public String getUserId() {
        return userId;
    }
}

public class ATM {
    public static void main(String[] args) {
        Account account = new Account("shaikarshad", "srm123", 1000.0); // Updated user ID and PIN
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM.");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        if (account.authenticate(userId, userPin)) {
            System.out.println("Login successful.");
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. View Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Balance: $" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's User ID: ");
                        String recipientUserId = scanner.next();
                        System.out.print("Enter transfer amount: $");
                        double transferAmount = scanner.nextDouble();
                        if (recipientUserId.equals(account.getUserId())) {
                            System.out.println("Cannot transfer to yourself.");
                        } else {
                            // In a real application, you would look up the recipient's account based on their userID.
                            // Replace these values with the actual recipient's User ID, PIN, and initial balance.
                            Account recipientAccount = new Account("recipientID", "recipientPIN", 1000.0);
                            account.transfer(recipientAccount, transferAmount);
                        }
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Please check your User ID and PIN.");
        }
    }
}
