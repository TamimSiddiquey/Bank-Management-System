public class BankAccount {

    // ENCAPSULATION

    private String accountNumber;   
    private String ownerName;       
    private double balance;       


    // CONSTRUCTOR
    
    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber    = accountNumber;
        this.ownerName        = ownerName;
        this.balance          = initialBalance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("  [SUCCESS] Deposited BDT " + amount);
            System.out.println("  New Balance: BDT " + balance);
        } else {
            System.out.println("  [ERROR] Deposit amount must be greater than 0.");
        }
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  [ERROR] Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("  [ERROR] Insufficient balance! Current balance: BDT " + balance);
        } else {
            balance -= amount;
            System.out.println("  [SUCCESS] Withdrew BDT " + amount);
            System.out.println("  New Balance: BDT " + balance);
        }
    }

    // Show all account details on screen
    public void displayAccountInfo() {
        System.out.println("  --------------------------");
        System.out.println("  Account Number : " + accountNumber);
        System.out.println("  Owner Name     : " + ownerName);
        System.out.println("  Balance        : BDT " + balance);
        System.out.println("  --------------------------");
    }

    // Transfer money to another BankAccount object
    public void transfer(BankAccount targetAccount, double amount) {
        System.out.println("  Transferring BDT " + amount + " to " + targetAccount.ownerName + "...");
        if (amount <= 0) {
            System.out.println("  [ERROR] Transfer amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("  [ERROR] Insufficient balance for transfer!");
        } else {
            balance -= amount;
            targetAccount.balance += amount;
            System.out.println("  [SUCCESS] Transfer complete.");
            System.out.println("  Your New Balance : BDT " + balance);
            System.out.println("  " + targetAccount.ownerName + "'s New Balance: BDT " + targetAccount.balance);
        }
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Getter
    public String getOwnerName() {
        return ownerName;
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }
}
