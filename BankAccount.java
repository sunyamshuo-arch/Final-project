/**
 * Program Description: This class represents one bank account.
 * It stores the account holder name, account number, and balance.
 *
 * Name: Yanshuo Sun
 * Date: December 5, 2026
 */

/**
 * The BankAccount class stores information for a single bank account.
 */
public class BankAccount {
    private static int nextAccountNumber = 1001;

    private int accountNumber;
    private String accountHolderName;
    private double balance;

    /**
     * Creates a new bank account with a unique account number.
     *
     * @param accountHolderName the name of the account holder
     * @param balance the starting balance of the account
     * @throws IllegalArgumentException if the name is empty or balance is negative
     */
    public BankAccount(String accountHolderName, double balance) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Starting balance cannot be negative.");
        }

        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    /**
     * Gets the account number.
     *
     * @return the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the account holder name.
     *
     * @return the account holder name
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Sets the account holder name.
     *
     * @param accountHolderName the new account holder name
     * @throws IllegalArgumentException if the name is empty
     */
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty.");
        }

        this.accountHolderName = accountHolderName;
    }

    /**
     * Gets the account balance.
     *
     * @return the current account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits money into the account.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is less than or equal to zero
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }

        balance += amount;
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is invalid or greater than the balance
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        balance -= amount;
    }

    /**
     * Generates a statement for this account.
     *
     * @return a formatted account statement
     */
    public String generateStatement() {
        return "Account Statement\n"
                + "-------------------------\n"
                + "Account Number: " + accountNumber + "\n"
                + "Account Holder: " + accountHolderName + "\n"
                + "Balance: $" + String.format("%.2f", balance);
    }

    /**
     * Returns account information as a string.
     *
     * @return account information
     */
    public String toString() {
        return accountNumber + " - " + accountHolderName + " - $" + String.format("%.2f", balance);
    }
}