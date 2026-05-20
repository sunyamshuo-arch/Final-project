/**
 * Program Description: This class manages multiple bank accounts using an ArrayList.
 * It can create, search, edit, remove, deposit, withdraw, and generate statements.
 *
 * Name: Yanshuo Sun
 * Date: December 5, 2026
 */

import java.util.ArrayList;

/**
 * The BankManager class stores and manages BankAccount objects.
 */
public class BankManager {
    private ArrayList<BankAccount> accounts;

    /**
     * Creates a BankManager object with an empty ArrayList.
     */
    public BankManager() {
        accounts = new ArrayList<BankAccount>();
    }

    /**
     * Creates and adds a new account.
     *
     * @param name the account holder name
     * @param balance the starting balance
     * @return the new BankAccount object
     */
    public BankAccount createAccount(String name, double balance) {
        BankAccount account = new BankAccount(name, balance);
        accounts.add(account);
        return account;
    }

    /**
     * Gets all bank accounts.
     *
     * @return an ArrayList of BankAccount objects
     */
    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    /**
     * Finds an account by account number.
     *
     * @param accountNumber the account number to search for
     * @return the matching BankAccount object, or null if not found
     */
    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    /**
     * Edits the name of an account.
     *
     * @param accountNumber the account number to edit
     * @param newName the new account holder name
     * @throws IllegalArgumentException if the account is not found
     */
    public void editAccount(int accountNumber, String newName) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }

        account.setAccountHolderName(newName);
    }

    /**
     * Removes an account from the ArrayList.
     *
     * @param accountNumber the account number to remove
     * @throws IllegalArgumentException if the account is not found
     */
    public void removeAccount(int accountNumber) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }

        accounts.remove(account);
    }

    /**
     * Deposits money into an account.
     *
     * @param accountNumber the account number
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the account is not found or amount is invalid
     */
    public void deposit(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }

        account.deposit(amount);
    }

    /**
     * Withdraws money from an account.
     *
     * @param accountNumber the account number
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the account is not found or amount is invalid
     */
    public void withdraw(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }

        account.withdraw(amount);
    }

    /**
     * Generates a statement for an account.
     *
     * @param accountNumber the account number
     * @return the account statement
     * @throws IllegalArgumentException if the account is not found
     */
    public String generateStatement(int accountNumber) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found.");
        }

        return account.generateStatement();
    }
}