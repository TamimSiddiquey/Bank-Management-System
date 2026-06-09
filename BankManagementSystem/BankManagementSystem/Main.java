import java.util.Scanner;

public class Main {

    static BankAccount[] accounts = new BankAccount[10];
    static int totalAccounts = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: createAccount();     break;
                case 2: deposit();           break;
                case 3: withdraw();          break;
                case 4: transfer();          break;
                case 5: checkBalance();      break;
                case 6: viewAllAccounts();   break;
                case 7:
                    System.out.println("\n  Goodbye! Thank you for using BankSystem.");
                    break;
                default:
                    System.out.println("\n  [ERROR] Invalid choice. Please enter 1-7.");
            }

        } while (choice != 7);

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("       BANK MANAGEMENT SYSTEM          ");
        System.out.println("========================================");
        System.out.println("  1. Create New Account");
        System.out.println("  2. Deposit Money");
        System.out.println("  3. Withdraw Money");
        System.out.println("  4. Transfer Money");
        System.out.println("  5. Check Balance");
        System.out.println("  6. View All Accounts");
        System.out.println("  7. Exit");
    }

    //  1. Create a new BankAccount OBJECT from user input
    static void createAccount() {
        if (totalAccounts >= 10) {
            System.out.println("\n  [ERROR] Maximum 10 accounts reached.");
            return;
        }

        System.out.println("\n--- Create New Account ---");
        System.out.print("  Enter Account Number (e.g. ACC-001): ");
        String accNum = sc.nextLine();

        System.out.print("  Enter Account Holder Name          : ");
        String name = sc.nextLine();

        System.out.print("  Enter Initial Deposit Amount (BDT) : ");
        double initialBalance = sc.nextDouble();
        sc.nextLine();

        // OOP: Creating a new OBJECT using the BankAccount class CONSTRUCTOR
        accounts[totalAccounts] = new BankAccount(accNum, name, initialBalance);
        totalAccounts++;

        System.out.println("\n  [SUCCESS] Account created successfully!");
        accounts[totalAccounts - 1].displayAccountInfo();
    }

    //  2. Deposit money into an account
    static void deposit() {
        if (totalAccounts == 0) { System.out.println("\n  [ERROR] No accounts exist yet."); return; }

        System.out.println("\n--- Deposit Money ---");
        System.out.print("  Enter Account Number: ");
        String accNum = sc.nextLine();

        BankAccount acc = findAccount(accNum);
        if (acc == null) return;

        System.out.print("  Enter amount to deposit (BDT): ");
        double amount = sc.nextDouble();
        sc.nextLine();

        //Calling the deposit() METHOD on the object
        acc.deposit(amount);
    }

    //  3. Withdraw money from an account
    static void withdraw() {
        if (totalAccounts == 0) { System.out.println("\n  [ERROR] No accounts exist yet."); return; }

        System.out.println("\n--- Withdraw Money ---");
        System.out.print("  Enter Account Number: ");
        String accNum = sc.nextLine();

        BankAccount acc = findAccount(accNum);
        if (acc == null) return;

        System.out.print("  Enter amount to withdraw (BDT): ");
        double amount = sc.nextDouble();
        sc.nextLine();

        // Calling the withdraw() METHOD on the object
        acc.withdraw(amount);
    }

    //  4. Transfer money between two accounts
    static void transfer() {
        if (totalAccounts < 2) { System.out.println("\n  [ERROR] Need at least 2 accounts to transfer."); return; }

        System.out.println("\n--- Transfer Money ---");
        System.out.print("  Enter YOUR Account Number   : ");
        String fromNum = sc.nextLine();

        System.out.print("  Enter TARGET Account Number : ");
        String toNum = sc.nextLine();

        BankAccount fromAcc = findAccount(fromNum);
        BankAccount toAcc   = findAccount(toNum);
        if (fromAcc == null || toAcc == null) return;

        System.out.print("  Enter amount to transfer (BDT): ");
        double amount = sc.nextDouble();
        sc.nextLine();

        // Calling the transfer() METHOD — one object talks to another object
        fromAcc.transfer(toAcc, amount);
    }

    //  5. Check balance of an account
    static void checkBalance() {
        if (totalAccounts == 0) { System.out.println("\n  [ERROR] No accounts exist yet."); return; }

        System.out.println("\n--- Check Balance ---");
        System.out.print("  Enter Account Number: ");
        String accNum = sc.nextLine();

        BankAccount acc = findAccount(accNum);
        if (acc == null) return;

        // Calling displayAccountInfo() METHOD on the object
        acc.displayAccountInfo();
    }

    //  6. Show all existing accounts
    static void viewAllAccounts() {
        if (totalAccounts == 0) {
            System.out.println("\n  [ERROR] No accounts created yet.");
            return;
        }
        System.out.println("\n--- All Accounts ---");
        for (int i = 0; i < totalAccounts; i++) {
            accounts[i].displayAccountInfo();
        }
    }

    //  Helper: Find an account by account number
    static BankAccount findAccount(String accNum) {
        for (int i = 0; i < totalAccounts; i++) {
            if (accounts[i].getAccountNumber().equalsIgnoreCase(accNum)) {
                return accounts[i];
            }
        }
        System.out.println("\n  [ERROR] Account '" + accNum + "' not found.");
        return null;
    }
}
