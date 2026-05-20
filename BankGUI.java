/**
 * Program Description: This class creates the graphical user interface for
 * the Bank Account Management application.
 *
 * Name: Yanshuo Sun
 * Date: December 5, 2026
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * The BankGUI class creates a GUI for managing bank accounts.
 */
public class BankGUI extends JFrame {
    private BankManager manager;
    private DefaultListModel<String> accountListModel;
    private JList<String> accountList;
    private JTextField nameField;
    private JTextField balanceField;
    private JTextField amountField;
    private JTextArea outputArea;

    /**
     * Creates the GUI window and all GUI components.
     */
    public BankGUI() {
        manager = new BankManager();

        setTitle("Bank Account Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createComponents();
    }

    /**
     * Creates and arranges all GUI components.
     *
     * @return nothing
     */
    private void createComponents() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Account Holder Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Starting Balance:"));
        balanceField = new JTextField();
        inputPanel.add(balanceField);

        inputPanel.add(new JLabel("Deposit / Withdraw Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        accountListModel = new DefaultListModel<String>();
        accountList = new JList<String>(accountListModel);
        JScrollPane listScrollPane = new JScrollPane(accountList);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));

        JButton createButton = new JButton("Create Account");
        JButton editButton = new JButton("Edit Name");
        JButton removeButton = new JButton("Remove Account");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton statementButton = new JButton("Statement");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(createButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(statementButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputScrollPane, BorderLayout.SOUTH);

        createButton.addActionListener(e -> createAccount());
        editButton.addActionListener(e -> editAccount());
        removeButton.addActionListener(e -> removeAccount());
        depositButton.addActionListener(e -> depositMoney());
        withdrawButton.addActionListener(e -> withdrawMoney());
        statementButton.addActionListener(e -> showStatement());
        clearButton.addActionListener(e -> clearFields());
        exitButton.addActionListener(e -> System.exit(0));
    }

    /**
     * Creates a new bank account from user input.
     *
     * @return nothing
     */
    private void createAccount() {
        try {
            String name = nameField.getText();
            double balance = Double.parseDouble(balanceField.getText());

            BankAccount account = manager.createAccount(name, balance);
            outputArea.setText("Account created successfully.\nAccount Number: "
                    + account.getAccountNumber());

            updateAccountList();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid balance.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * Edits the selected account holder name.
     *
     * @return nothing
     */
    private void editAccount() {
        try {
            BankAccount account = getSelectedAccount();
            String newName = nameField.getText();

            manager.editAccount(account.getAccountNumber(), newName);
            outputArea.setText("Account name updated successfully.");

            updateAccountList();
            clearFields();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * Removes the selected bank account.
     *
     * @return nothing
     */
    private void removeAccount() {
        try {
            BankAccount account = getSelectedAccount();

            manager.removeAccount(account.getAccountNumber());
            outputArea.setText("Account removed successfully.");

            updateAccountList();
            clearFields();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * Deposits money into the selected account.
     *
     * @return nothing
     */
    private void depositMoney() {
        try {
            BankAccount account = getSelectedAccount();
            double amount = Double.parseDouble(amountField.getText());

            manager.deposit(account.getAccountNumber(), amount);
            outputArea.setText("Deposit successful.");

            updateAccountList();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * Withdraws money from the selected account.
     *
     * @return nothing
     */
    private void withdrawMoney() {
        try {
            BankAccount account = getSelectedAccount();
            double amount = Double.parseDouble(amountField.getText());

            manager.withdraw(account.getAccountNumber(), amount);
            outputArea.setText("Withdraw successful.");

            updateAccountList();
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * Shows a statement for the selected account.
     *
     * @return nothing
     */
    private void showStatement() {
        try {
            BankAccount account = getSelectedAccount();
            String statement = manager.generateStatement(account.getAccountNumber());

            outputArea.setText(statement);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    /**
     * Gets the selected account from the JList.
     *
     * @return the selected BankAccount object
     * @throws IllegalArgumentException if no account is selected
     */
    private BankAccount getSelectedAccount() {
        int index = accountList.getSelectedIndex();

        if (index == -1) {
            throw new IllegalArgumentException("Please select an account first.");
        }

        return manager.getAccounts().get(index);
    }

    /**
     * Updates the JList to show all accounts.
     *
     * @return nothing
     */
    private void updateAccountList() {
        accountListModel.clear();

        for (BankAccount account : manager.getAccounts()) {
            accountListModel.addElement(account.toString());
        }
    }

    /**
     * Clears all text fields.
     *
     * @return nothing
     */
    private void clearFields() {
        nameField.setText("");
        balanceField.setText("");
        amountField.setText("");
    }
}