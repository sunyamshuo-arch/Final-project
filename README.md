# Bank Account Management System

## Author

Yanshuo Sun

## Description

This project is a Java Bank Account Management application. The program allows the user to manage multiple bank accounts through a graphical user interface.

The application uses an `ArrayList` to store multiple `BankAccount` objects. Each bank account has an account holder name, a unique account number, and a balance.

The program also uses a static variable to automatically generate unique account numbers. Exception handling is used to prevent invalid actions, such as entering negative deposits, withdrawing more money than the balance, or leaving the account holder name empty.

## Features

- Create a new bank account
- Edit an account holder's name
- Remove an account
- Deposit money
- Withdraw money
- Generate an account statement
- Store multiple accounts using an ArrayList
- Generate unique account numbers using a static variable
- Handle invalid input using exception handling
- Use a Java Swing GUI

## Project Files

```text
App.java
BankAccount.java
BankManager.java
BankGUI.java
README.md